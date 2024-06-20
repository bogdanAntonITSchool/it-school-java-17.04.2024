package generics.Super;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyClass<ClassA> myClassA = new MyClass<>(new ClassA());
        MyClass<ClassA> myClassB = new MyClass<>(new ClassB("str"));
        MyClass<ClassA> myClassC = new MyClass<>(new ClassC());

        myClassA.doSomeLogic();
        myClassB.doSomeLogic();
        myClassC.doSomeLogic();

        List<? super ClassA> list = new ArrayList<>();
        list.add(new ClassA());
        list.add(new ClassB("str"));
        list.add(new ClassC());
    }
}

class MyClass<T extends ClassA> {
    private T value;

    public MyClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void doSomeLogic() {
        if (value instanceof ClassC) {
            System.out.println("C");
        } else if (value instanceof ClassB) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}

class ClassA {
    public void print() {
        System.out.println("A");
    }
}
class ClassB extends ClassA {
    public ClassB(String str) {

    }
}
class ClassC extends ClassB {
    public ClassC() {
        super("Hello");
//        super.print();
    }
}