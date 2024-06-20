package generics;

public class MyClass<T> {
    private T value;

    public MyClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public <E> void doSomeLogic(E otherValue) {
        System.out.println(otherValue.getClass());
    }

//    public <T> void doSomeLogic(T otherValue) {
//        System.out.println(otherValue.getClass());
//    }
}
