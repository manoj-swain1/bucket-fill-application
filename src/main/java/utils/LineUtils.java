package utils;

import models.Canvas;

/**
 * LineUtils create lines on canvas
 *
 * @author Manoj Swain
 */
public class LineUtils {

    public static void drawLine(Canvas canvas, int x1, int y1, int x2, int y2, char marker) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                canvas.updateCanvas(i, j, marker);
            }
        }
    }
}
