import command.Command;
import exception.DrawException;

import java.util.Scanner;

/**
 * This class drives the application based on different types of commands provided
 *
 * @author Manoj Swain
 * created on 17-04-2022
 */
public class BucketFillApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command;
        while (true) {
            System.out.print("Enter Command:");
            command = scan.nextLine();
            try {
                Command commandExecutor = Command.from(command);
                commandExecutor
                        .getOperator()
                        .getOperationService()
                        .get()
                        .processOperation(commandExecutor.getOperands());
            } catch (DrawException ex) {
                System.out.println(ex.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("Error Occurred\n");
                e.printStackTrace();
                System.exit(1);
                scan.close();
            }
        }
    }
}
