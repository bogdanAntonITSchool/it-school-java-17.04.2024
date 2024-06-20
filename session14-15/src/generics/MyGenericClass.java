package generics;

public class MyGenericClass<K, V> {

    private K propOne;
    private V propTwo;

    public MyGenericClass(K propOne, V propTwo) {
        this.propOne = propOne;
        this.propTwo = propTwo;
    }

    public void printSum() {
        if (propOne instanceof Integer && propTwo instanceof Integer) {
            System.out.println((Integer) propOne + (Integer) propTwo);
        } else if (propOne instanceof String && propTwo instanceof String) {
            System.out.println((String) propOne + (String) propTwo);
        } else {
            System.out.println("Cannot sum values");
        }
    }
}
