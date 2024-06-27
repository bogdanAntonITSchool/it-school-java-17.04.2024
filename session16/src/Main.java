public class Main {
    public static void main(String[] args) {
        Double x = 10.0;
        Object y = x;

        // instanceof with pattern variable
        if (y instanceof String z) {
            System.out.println("String: " + z);
        } else if (y instanceof Double z) {
            System.out.println("Double: " + z);
        }
    }
}