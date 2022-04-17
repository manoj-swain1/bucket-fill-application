package service;

import constants.AppConstants;
import exception.CanvasException;
import exception.DrawException;
import exception.IllegalInputArgumentsException;
import lombok.Getter;
import models.Canvas;

import java.awt.*;
import java.util.LinkedList;

public class BucketFillService extends OperationService implements ShapeService {
    @Getter
    private static final BucketFillService instance = new BucketFillService();

    private BucketFillService() {
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
        if (coordinates == null || coordinates.length != AppConstants.LENGTH_OF_FILL_CMD) {
            throw new IllegalInputArgumentsException("Illegal argument. Pass a valid argument. Try again[B x y c].");
        }
        try {
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            char previousColor = canvas.getCanvas()[y][x];
            bucketFill(x, y, canvas, coordinates[2].charAt(0), previousColor);
        } catch (NumberFormatException ex) {
            throw new IllegalInputArgumentsException("Illegal argument. Pass numeric value for X and Y coordinate. Try again[B x y c].");
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new CanvasException("Coordinate is out of canvas range." + canvas);
        }

    }

    private boolean isValid(Canvas template, int x, int y, int prevC, int newC) {
        var canvas = template.getCanvas();
        if (x < 1 || x > template.getWidth() - 2 || y < 1 || y > template.getHeight() - 2) {
            return false;
        }
        return canvas[y][x] == prevC && canvas[y][x] != newC;
    }

    private void bucketFill(int x, int y, Canvas template, char newColor, char previousColor) {
        if (!isValid(template, x, y, previousColor, newColor)) {
            return;
        }

        var queue = new LinkedList<>();

        // Append the position of starting pixel of the component
        queue.add(new Point(x, y));

        // Color the pixel with the new color
        template.updateCanvas(y, x, newColor);

        while (!queue.isEmpty()) {
            Point currPixel = (Point) queue.pollLast();

            int posX = currPixel.x;
            int posY = currPixel.y;

            // Check if the adjacent pixels are valid
            if (isValid(template, posX + 1, posY, previousColor, newColor)) {
                template.updateCanvas(posY, posX + 1, newColor);
                queue.add(new Point(posX + 1, posY));
            }

            if (isValid(template, posX - 1, posY, previousColor, newColor)) {
                template.updateCanvas(posY, posX - 1, newColor);
                queue.add(new Point(posX - 1, posY));
            }

            if (isValid(template, posX, posY + 1, previousColor, newColor)) {
                template.updateCanvas(posY + 1, posX, newColor);
                queue.add(new Point(posX, posY + 1));
            }

            if (isValid(template, posX, posY - 1, previousColor, newColor)) {
                template.updateCanvas(posY - 1, posX, newColor);
                queue.add(new Point(posX, posY - 1));
            }
        }
    }
}
