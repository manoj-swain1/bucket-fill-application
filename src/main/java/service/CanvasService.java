package service;

import constants.AppConstants;
import exception.DrawException;
import exception.IllegalInputArgumentsException;
import lombok.Getter;
import models.Canvas;
import utils.LineUtils;

public class CanvasService extends OperationService implements ShapeService {
    @Getter
    private static final CanvasService instance = new CanvasService();

    private CanvasService() {
    }

    @Override
    public void processOperation(String[] coordinates) {
        if (coordinates == null || coordinates.length != AppConstants.LENGTH_OF_CANVAS_CMD) {
            throw new IllegalInputArgumentsException("Pass valid argument! Try again[C width height].");
        }

        makeCanvas(coordinates);

        this.makeShape(canvas, coordinates);
        this.draw(canvas);
    }

    private void makeCanvas(String[] coordinates) {
        int width = Integer.parseInt(coordinates[0]);
        int height = Integer.parseInt(coordinates[1]);
        canvas = new Canvas(width, height);
    }

    @Override
    public void makeShape(Canvas canvas, String[] coordinates) throws DrawException {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        LineUtils.drawLine(canvas, 0, 0, width - 1, 0, AppConstants.H_BORDER);
        LineUtils.drawLine(canvas, 0, height - 1, width - 1, height - 1, AppConstants.H_BORDER);
        LineUtils.drawLine(canvas, 0, 1, 0, height - 2, AppConstants.V_BORDER);
        LineUtils.drawLine(canvas, width - 1, 1, width - 1, height - 2, AppConstants.V_BORDER);
    }
}
