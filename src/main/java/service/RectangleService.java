package service;

import constants.AppConstants;
import exception.CanvasException;
import exception.DrawException;
import exception.IllegalInputArgumentsException;
import lombok.Getter;
import models.Canvas;
import utils.LineUtils;

public class RectangleService extends OperationService implements ShapeService {
    @Getter
    private static final RectangleService instance = new RectangleService();

    private RectangleService() {
    }

    @Override
    public void processOperation(String[] arguments) throws DrawException {
        this.makeShape(canvas, arguments);
        this.draw(canvas);
    }

    @Override
    public void makeShape(Canvas canvas, String[] coordinates) {
        if (canvas == null) {
            throw new CanvasException("Canvas Not Found! Please draw canvas before making any shape! Try again[C width height].\n");
        }
        if (coordinates == null || coordinates.length != AppConstants.LENGTH_OF_RECTANGLE_CMD) {
            throw new IllegalInputArgumentsException("Pass valid arguments to Rectangle command! Try again[R x1 y1 x2 y2].");
        }
        try {
            int x1 = Integer.parseInt(coordinates[0]);
            int y1 = Integer.parseInt(coordinates[1]);
            int x2 = Integer.parseInt(coordinates[2]);
            int y2 = Integer.parseInt(coordinates[3]);
            if (x1 < x2 && y1 < y2) {
                LineUtils.drawLine(canvas, x1, y1, x2, y1, AppConstants.LINE_FEED);
                LineUtils.drawLine(canvas, x1, y1, x1, y2, AppConstants.LINE_FEED);
                LineUtils.drawLine(canvas, x2, y1, x2, y2, AppConstants.LINE_FEED);
                LineUtils.drawLine(canvas, x1, y2, x2, y2, AppConstants.LINE_FEED);
            } else {
                throw new IllegalInputArgumentsException("Illegal argument. Should be x1 < x2 and y1 < y2. Try again[R x1 y1 x2 y2].");
            }
        } catch (NumberFormatException ex) {
            throw new IllegalInputArgumentsException("Illegal argument.Pass numeric argument for x1, y1, x2 and y2. Try again[R x1 y1 x2 y2].");
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new CanvasException("Coordinate is out of canvas range." + canvas);
        }
    }
}
