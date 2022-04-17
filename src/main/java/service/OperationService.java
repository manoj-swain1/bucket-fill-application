package service;

import models.Canvas;

public abstract class OperationService {
    public static Canvas canvas = null;

    public abstract void processOperation(String[] arguments);
}
