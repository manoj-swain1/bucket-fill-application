package service;

import exception.CanvasException;
import exception.IllegalInputArgumentsException;
import models.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BucketFillServiceTest {
    BucketFillService bucketFillService;

    @BeforeEach
    void setup() {
        bucketFillService = BucketFillService.getInstance();
        OperationService.canvas = new Canvas(20, 4);
    }

    @Test
    void testProcessOperation() {
        LineService.getInstance().processOperation(new String[]{"1", "2", "6", "2"});
        LineService.getInstance().processOperation(new String[]{"6", "3", "6", "4"});
        RectangleService.getInstance().processOperation(new String[]{"14", "1", "18", "3"});
        bucketFillService.processOperation(new String[]{"10", "3", "o"});
        Assertions.assertEquals('o', OperationService.canvas.getCanvas()[1][1]);
        Assertions.assertEquals('o', OperationService.canvas.getCanvas()[1][2]);
        Assertions.assertEquals('o', OperationService.canvas.getCanvas()[1][3]);
    }

    @Test
    void whenCanvasIsNullThenThrowCanvasException() {
        OperationService.canvas = null;
        Assertions.assertThrows(CanvasException.class, () -> bucketFillService.processOperation(null));
    }

    @Test
    void whenCoordinatesPassedIsNullThenThrowIllegalInputArgumentsException() {

        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> bucketFillService.processOperation(null));
    }

    @Test
    void whenCoordinatesPassedIsNotEquals3ThenThrowIllegalInputArgumentsException() {
        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> bucketFillService.processOperation(new String[]{"20", "4"}));
    }

    @Test
    void whenCoordinatesPassedIsNotIntegerThenThrowIllegalInputArgumentsException() {
        Assertions.assertThrows(IllegalInputArgumentsException.class, () -> bucketFillService.processOperation(new String[]{"x", "4", "5"}));
    }

    @Test
    void whenCoordinatesPassedIsNotInCanvasRangeThenThrowCanvasException() {
        Assertions.assertThrows(CanvasException.class, () -> bucketFillService.processOperation(new String[]{"22", "4", "o"}));
    }

}