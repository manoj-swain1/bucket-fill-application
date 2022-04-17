package service;

import exception.IllegalInputArgumentsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CanvasServiceTest {

    CanvasService canvasService;

    @BeforeEach
    void setup() {
        canvasService = CanvasService.getInstance();
    }

    @Test
    void testProcessOperation() {
        canvasService.processOperation(new String[]{"20", "4"});
        Assertions.assertEquals(22, OperationService.canvas.getWidth());
        Assertions.assertEquals(6, OperationService.canvas.getHeight());
        Assertions.assertEquals('-', OperationService.canvas.getCanvas()[0][0]);
        Assertions.assertEquals('|', OperationService.canvas.getCanvas()[1][0]);
    }

    @Test
    void whenCoordinatesPassedIsNullThenThrowIllegalInputArgumentsException() {
        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> canvasService.processOperation(null));
    }

    @Test
    void whenCoordinatesPassedIsNotEquals2ThenThrowIllegalInputArgumentsException() {
        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> canvasService.processOperation(new String[]{"20", "4", "5"}));
    }

}