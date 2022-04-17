package service;

import exception.CanvasException;
import exception.IllegalInputArgumentsException;
import models.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectangleServiceTest {
    RectangleService rectangleService;

    @BeforeEach
    void setup() {
        rectangleService = RectangleService.getInstance();
        OperationService.canvas = new Canvas(20, 4);
    }

    @Test
    void testProcessOperation() {
        rectangleService.processOperation(new String[]{"14", "1", "18", "3"});
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[1][14]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[1][15]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[1][16]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[1][17]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[1][18]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[2][14]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[3][14]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[3][15]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[3][16]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[3][17]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[3][18]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[2][18]);
    }

    @Test
    void whenCanvasIsNullThenThrowCanvasException() {
        OperationService.canvas = null;
        Assertions.assertThrows(CanvasException.class, () -> rectangleService.processOperation(null));
    }

    @Test
    void whenCoordinatesPassedIsNullThenThrowIllegalInputArgumentsException() {

        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> rectangleService.processOperation(null));
    }

    @Test
    void whenCoordinatesPassedIsNotEquals4ThenThrowIllegalInputArgumentsException() {
        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> rectangleService.processOperation(new String[]{"20", "4", "5"}));
    }

    @Test
    void whenCoordinatesPassedIsNotIntegerThenThrowIllegalInputArgumentsException() {
        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> rectangleService.processOperation(new String[]{"x", "4", "5","6"}));
    }

    @Test
    void whenCoordinatesPassedIsNotInCanvasRangeThenThrowCanvasException() {
        Assertions.assertThrows(CanvasException.class, () -> rectangleService.processOperation(new String[]{"20", "4", "30", "5"}));
    }

    @Test
    void whenCoordinatesAreNotCorrectForLineInCanvasRangeThenThrowIllegalInputArgumentsException() {
        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> rectangleService.processOperation(new String[]{"30", "4", "20", "5"}));
    }
}