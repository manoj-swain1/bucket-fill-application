package enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import service.*;

import java.util.function.Supplier;

/**
 * This class returns service implementation for specific commands
 *
 * @author Manoj Swain
 * created on 17-04-2022
 */
@RequiredArgsConstructor
@Getter
public enum Operator {
    C(CanvasService::getInstance),
    L(LineService::getInstance),
    R(RectangleService::getInstance),
    B(BucketFillService::getInstance),
    Q(QuitService::getInstance);


    @NonNull
    private final Supplier<? extends OperationService> operationService;
}
