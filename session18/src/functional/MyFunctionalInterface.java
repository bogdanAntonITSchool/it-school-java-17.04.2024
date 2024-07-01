package functional;

@FunctionalInterface
public interface MyFunctionalInterface {
    void sayHello(String hello);

    default void sayBye() {
        System.out.println("Bye");
    }
}
