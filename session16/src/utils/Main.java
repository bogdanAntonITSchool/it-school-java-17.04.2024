package utils;

import homework.Operation;
import utils.helper.OperationHelper;
import utils.util.OperationUtil;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // By providing a seed to the Random object, we can get the same sequence of random numbers every time we run the program.
        Random random = new Random(10);

        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(10) + ", ");
        }

        double a = 10;
        double b = 5;

        System.out.println(OperationUtil.computeOperation(Operation.ADD, a, b));
        System.out.println(OperationUtil.computeOperation(Operation.DIVIDE, a, b));
        System.out.println(OperationUtil.computeOperation(Operation.SUBTRACT, a, b));
        System.out.println(OperationUtil.computeOperation(Operation.MULTIPLY, a, b));

        OperationHelper operationHelper = new OperationHelper(a, b);
        System.out.println(operationHelper.add());
        System.out.println(operationHelper.divide());
        System.out.println(operationHelper.subtract());
        System.out.println(operationHelper.multiply());

        OperationHelper operationHelper1 = new OperationHelper(a, b, Operation.DIVIDE);
        System.out.println(operationHelper1.calculate());
        System.out.println(operationHelper1.calculate());
        System.out.println(operationHelper1.calculate());
        System.out.println(operationHelper1.calculate());
    }
}
