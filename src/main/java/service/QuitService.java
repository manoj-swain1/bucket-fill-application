package service;

import lombok.Getter;

public class QuitService extends OperationService {
    @Getter
    private static final QuitService instance = new QuitService();

    private QuitService() {
    }

    @Override
    public void processOperation(String[] arguments) {
        System.out.println("Thanks for using application. Quiting from application!");
        canvas = null;
        System.exit(0);
    }
}
