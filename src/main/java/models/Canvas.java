package models;

import lombok.Getter;

import java.util.Arrays;

/**
 * Canvas template to hold canvas data
 *
 * @author Manoj Swain
 * created on 17-04-2022
 */
@Getter
public class Canvas {
    private final char[][] canvas;
    private final int width;
    private final int height;

    /**
     * Constructor to create canvas
     * Adding 2 to both height and width for border
     *
     * @param width  width of canvas
     * @param height height of canvas
     */
    public Canvas(int width, int height) {
        height += 2;
        width += 2;
        this.width = width;
        this.height = height;
        canvas = new char[height][width];
        Arrays.stream(canvas).forEach(a -> Arrays.fill(a, ' '));
    }

    public void updateCanvas(int yCoordinate, int xCoordinate, char newColor) {
        canvas[yCoordinate][xCoordinate] = newColor;
    }

    @Override
    public String toString() {
        return " Canvas [" + "width=" + (width - 2) + ", height=" + (height - 2) + "] ";
    }
}
