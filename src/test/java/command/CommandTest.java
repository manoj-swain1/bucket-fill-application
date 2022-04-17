package command;

import enums.Operator;
import exception.CommandNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandTest {

    @Test
    public void testMethodFromForValidInput() {
        Command cmd = Command.from("C 20 4");
        Assertions.assertEquals(Operator.C, cmd.getOperator());
        Assertions.assertEquals(2, cmd.getOperands().length);
    }

    @Test
    public void testMethodFromForInValidInput() {
        Assertions.assertThrows(CommandNotFoundException.class, () -> Command.from("D 20 4"));
    }
}