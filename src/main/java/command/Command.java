package command;

import enums.Operator;
import exception.CommandNotFoundException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * This class converts command into operator and operands to process
 *
 * @author Manoj Swain
 * created on 17-04-2022
 */
@RequiredArgsConstructor
@Getter
public class Command {
    @NonNull
    private Operator operator;
    @NonNull
    private String[] operands;

    private static final String SEPARATOR = " ";

    public static Command from(String str) {
        try {
            String[] commandWithArguments = str.split(SEPARATOR);
            Operator operator = Operator.valueOf(commandWithArguments[0]);
            String[] operands =
                    Arrays.stream(commandWithArguments).skip(1).toArray(String[]::new);

            return new Command(operator, operands);
        } catch (Exception e) {
            throw new CommandNotFoundException("Invalid Command Supplied: " + str);
        }
    }
}
