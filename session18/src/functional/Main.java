package functional;

public class Main {
    public static void main(String[] args) {

        MyFunctionalInterface myFunctionalInterface = new MyFunctionalInterface() {
            @Override
            public void sayHello(String hello) {
                System.out.println(hello);
            }

            @Override
            public void sayBye() {
                MyFunctionalInterface.super.sayBye();
            }

            public void saySomething(String something) {
                System.out.println(something);
            }
        };

        myFunctionalInterface.sayHello("Hello");
        myFunctionalInterface.sayBye();

        MyFunctionalInterfaceImpl myFunctionalInterfaceImpl = new MyFunctionalInterfaceImpl();
        myFunctionalInterfaceImpl.saySomething("Something");

        MyFunctionalInterface myFunctionalInterface2 = (s) -> System.out.println(s);
        myFunctionalInterface2.sayHello("vdfbdfbf");

        ComputeTwoNumbers sumOfTwoNumbers = (a, b) -> a + b;
        int sum = sumOfTwoNumbers.compute(2, 3);
        System.out.println(sum);

        ComputeTwoNumbers subtract = (a, b) -> a - b;
        int sub = subtract.compute(2, 3);
        System.out.println(sub);

        ComputeTwoNumbers multiply = (a, b) -> {
            System.out.println("Multiplying " + a + " and " + b);
            return a * b;
        };
        int mult = multiply.compute(2, 3);
        System.out.println(mult);
    }

    @FunctionalInterface
    interface ComputeTwoNumbers {
        int compute(Integer a, Integer b);
    }

    static class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
        @Override
        public void sayHello(String hello) {
            System.out.println(hello);
        }
        public void saySomething(String something) {
            System.out.println(something);
        }
    }
}
