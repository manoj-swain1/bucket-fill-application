package service;

import exception.CanvasException;
import exception.IllegalInputArgumentsException;
import models.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineServiceTest {
    LineService lineService;

    @BeforeEach
    void setup() {
        lineService = LineService.getInstance();
        OperationService.canvas = new Canvas(20, 4);
    }

    @Test
    void testProcessOperation() {
        lineService.processOperation(new String[]{"1", "2", "6", "2"});
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[2][1]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[2][2]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[2][3]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[2][4]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[2][5]);
        Assertions.assertEquals('x', OperationService.canvas.getCanvas()[2][6]);
    }

    @Test
    void whenCanvasIsNullThenThrowCanvasException() {
        OperationService.canvas = null;
        Assertions.assertThrows(CanvasException.class, () -> lineService.processOperation(null));
    }

    @Test
    void whenCoordinatesPassedIsNullThenThrowIllegalInputArgumentsException() {

        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> lineService.processOperation(null));
    }

    @Test
    void whenCoordinatesPassedIsNotEquals4ThenThrowIllegalInputArgumentsException() {
        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> lineService.processOperation(new String[]{"20", "4", "5"}));
    }

    @Test
    void whenCoordinatesPassedIsNotIntegerThenThrowIllegalInputArgumentsException() {
        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> lineService.processOperation(new String[]{"x", "4", "5", "6"}));
    }

    @Test
    void whenCoordinatesPassedIsNotInCanvasRangeThenThrowCanvasException() {
        Assertions.assertThrows(CanvasException.class, () -> lineService.processOperation(new String[]{"20", "4", "30", "4"}));
    }

    @Test
    void whenCoordinatesAreNotCorrectForLineInCanvasRangeThenThrowIllegalInputArgumentsException() {
        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> lineService.processOperation(new String[]{"20", "4", "30", "5"}));
    }
}