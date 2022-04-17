package service;

import constants.AppConstants;
import exception.CanvasException;
import exception.IllegalInputArgumentsException;
import lombok.Getter;
import models.Canvas;
import utils.LineUtils;

public class LineService extends OperationService implements ShapeService {
    @Getter
    private static final LineService instance = new LineService();

    private LineService() {
    }

    @Override
    public void processOperation(String[] arguments) {
        this.makeShape(canvas, arguments);
        this.draw(canvas);
    }

    @Override
    public void makeShape(Canvas canvas, String[] coordinates) {
        if (canvas == null) {
            throw new CanvasException("Canvas Not Found! Please draw canvas before making any shape! Try again[C width height].\n");
        }
        if (coordinates == null || coordinates.length != AppConstants.LENGTH_OF_LINE_CMD) {
            throw new IllegalInputArgumentsException("Please check the argument passed to Line command! Try again[L x1 y1 x2 y2].");
        }
        try {
            int x1 = Integer.parseInt(coordinates[0]);
            int y1 = Integer.parseInt(coordinates[1]);
            int x2 = Integer.parseInt(coordinates[2]);
            int y2 = Integer.parseInt(coordinates[3]);
            if ((x1 == x2 && y1 < y2) || (y1 == y2 && x1 < x2)) {
                LineUtils.drawLine(canvas, x1, y1, x2, y2, AppConstants.LINE_FEED);
            } else {
                throw new IllegalInputArgumentsException("Illegal argument. Should be either x1 = x2 and y1 < y2 Or y1= y2 and x1 < x2. Try again[L x1 y1 x2 y2].");
            }
        } catch (NumberFormatException ex) {
            throw new IllegalInputArgumentsException("Illegal argument. Pass numeric values for x1, y1, x2 and y2. Try again[L x1 y1 x2 y2].");
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new CanvasException("Coordinate is out of canvas range." + canvas);
        }

    }
}
