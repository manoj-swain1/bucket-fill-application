package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CanvasTest {
    Canvas canvas = null;

    @BeforeEach
    void setup() {
        canvas = new Canvas(20, 4);
    }

    @Test
    void testWidthAndHeightOfCanvas() {

        Assertions.assertEquals(22, canvas.getWidth());
        Assertions.assertEquals(6, canvas.getHeight());
        Assertions.assertNotNull(canvas.getCanvas());
    }

    @Test
    void testUpdateCanvas() {
        canvas.updateCanvas(3, 10, 'o');
        Assertions.assertEquals('o', canvas.getCanvas()[3][10]);
    }
}