package service;

import exception.DrawException;
import models.Canvas;

public interface ShapeService {

    /**
     * Creates the shape on given canvas.
     *
     * @param canvas      Canvas paper.
     * @param coordinates Coordinate commands.
     */
    void makeShape(Canvas canvas, String[] coordinates) throws DrawException;

    /**
     * Draws the shape of given canvas.
     *
     * @param canvasTemplate Canvas paper.
     */
    default void draw(Canvas canvasTemplate) {
        char[][] canvas = canvasTemplate.getCanvas();
        for (int i = 0; i < canvasTemplate.getHeight(); i++) {
            for (int j = 0; j < canvasTemplate.getWidth(); j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }
}
