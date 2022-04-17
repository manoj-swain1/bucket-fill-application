package constants;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppConstantsTest {

    @Test
    void test() {
        Assertions.assertEquals('x', AppConstants.LINE_FEED);
        Assertions.assertEquals(4, AppConstants.LENGTH_OF_RECTANGLE_CMD);
        Assertions.assertEquals('-', AppConstants.H_BORDER);
        Assertions.assertEquals('|', AppConstants.V_BORDER);
        Assertions.assertEquals(3, AppConstants.LENGTH_OF_FILL_CMD);
        Assertions.assertEquals(4, AppConstants.LENGTH_OF_LINE_CMD);
    }

}