import java.util.*;

public class Main {
    public static void main(String[] args) {
        Long myLongWrapper = Long.valueOf(123l);
        long myLongPrimitive = 123l;

        // This will return a Long object with the value 123, even though the parameter is a String
        Long longFromString = Long.valueOf("123");
        System.out.println(longFromString);

        // This will throw a NumberFormatException
        // Comment this line to avoid the exception
//        Long failed = Long.valueOf("12vv3");

        // This will throw a NumberFormatException
        // Comment this line to avoid the exception
//        Byte byteFromString = Byte.valueOf("1236546656");
//        System.out.println(byteFromString);

        Object o = new Object();
        // This will print the reference of the object, because the default Object toString method is used
        System.out.println(o);

        // These will print the value of the Long object
        System.out.println(myLongWrapper);
        System.out.println(myLongPrimitive);

        Long autoBoxedLong = 123l;
        long autoUnboxedLong = autoBoxedLong;

        System.out.println(autoBoxedLong);
        System.out.println(autoUnboxedLong);

        int[] ints = new int[4];
        ints[0] = 1;
        System.out.println(ints[0]);
        ints = new int[5];
        System.out.println(ints[0]);
        ints[4] = 1;

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1); // [1]
        integerList.add(2); // [1, 2]

        System.out.println(integerList.get(0)); // 1

        integerList.add(0, 3); // [3, 1, 2]
        System.out.println(integerList.get(0)); // 3
        System.out.println(integerList.get(1)); // 1
        System.out.println(integerList.get(2)); // 2

        integerList.set(0, 4); // [4, 1, 2]
        System.out.println(integerList.get(0)); // 4

        MyObject myObject = new MyObject("Bogdan");
        MyObject myObject1 = new MyObject("nadgoB");

        // The equals method is overridden to compare the length of the name
        if (myObject.equals(myObject1)) {
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");
        }

        // The rule for adding objects to a set is that the hash code is used to determine if the object is already in the set
        // If the hash code is the same, the equals() method is used to determine if the object is already in the set
        Set<MyObject> myObjectSet = new HashSet<>();
        myObjectSet.add(myObject);
        myObjectSet.add(myObject1);
        System.out.println(myObjectSet);

        B b = new B();
        // The reference a is of type A, but the object is of type C
        A a = new C();

        // The reference a is of type A, but the object is of type B
        // A a = new B();

        // Trying to cast a to B
        if (a instanceof B) {
            // If the cast is successful, the object is of type B
            // Since a is of type C; this will not be executed
            b = (B) a;
            System.out.println("a is an instance of B");
        } else {
            // If a is not an instance of B, this will be executed
            System.out.println("a is not an instance of B");
        }
    }

    // The class A is the superclass of B and C
    public static class A {}
    public static class B extends A {}
    public static class C extends A {}

    public static class MyObject {
        private String name;

        public MyObject(String name) {
            this.name = name;
        }

        // The equals method is overridden to compare the length of the name
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyObject myObject = (MyObject) o;
            return Objects.equals(name, myObject.name);
        }

        // The hash value for each object of type MyObject
        // is the length of the name property
        @Override
        public int hashCode() {
            return name.length();
        }

        // The toString method is overridden to print the name property
        // This is invoked when the object is printed
        @Override
        public String toString() {
            return "MyObject{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
