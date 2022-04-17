package enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.*;

class OperatorTest {

    @Test
    void test() {
        Assertions.assertEquals(CanvasService.getInstance(), Operator.C.getOperationService().get());
        Assertions.assertEquals(LineService.getInstance(), Operator.L.getOperationService().get());
        Assertions.assertEquals(RectangleService.getInstance(), Operator.R.getOperationService().get());
        Assertions.assertEquals(BucketFillService.getInstance(), Operator.B.getOperationService().get());
        Assertions.assertEquals(QuitService.getInstance(), Operator.Q.getOperationService().get());
    }

}