package generics;

public class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void printBoxContent() {
        System.out.println(value);
    }
}
