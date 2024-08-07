import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        average(1, 2, 3);
        average(1, 2, 0); // should return 0


        Object myObj = getObject(2);

        // some code


        if (myObj != null) {
            System.out.println(myObj.toString());
        } else {
            System.out.println("The object is null");
        }

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        int c = sum(a, b);
        System.out.println(c);

        int[] arr = getMeAnArray();
        if (arr != null && arr.length > 10) {
            arr[11] = 10;
        }
        System.out.println(arr[11]);


        try {
//            SQLException thisIsASqlException = new SQLException("This is a SQL exception");
            if (true) {
                throw new SQLException("This is a SQL exception");
            } else {
                throw new IOException("This is an IO exception");
            }
        } catch (SQLException | IOException e) {
            System.out.println("Caught an IO exception");
        }

//        FileReader fr = null;
//        try {
////            SQLException thisIsASqlException = new SQLException("This is a SQL exception");
//            System.out.println("being in the try block");
//            if (true) {
//                throw new SQLException("This is a SQL exception");
//            }
//            fr = new FileReader("test.txt");
//        } catch (SQLException e) {
//            System.out.println("Caught an exception");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } finally {
//            System.out.println("This is the finally block");
//            if (fr != null) {
//                try {
//                    fr.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }


        StringBuilder resultStringBuilder = new StringBuilder();
        try (FileReader fr = new FileReader("test.txt")) {
            String line = String.valueOf(fr.read());
            System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static int[] getMeAnArray() {
        return new int[50];
    }

    private static Object getObject(int i) {
        return i % 2 == 0 ? new Object() : null;
    }


    public static int sum(int a, int b) {
        return a + b;
    }


    public static double average(int a, int b, int c) {
        return c != 0
                ? (a + b) / c
                : 0;
    }
}