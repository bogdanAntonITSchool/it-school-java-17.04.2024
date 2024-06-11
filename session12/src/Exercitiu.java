import java.util.HashSet;
import java.util.Set;

public class Exercitiu {
    public static void main(String[] args) {
        MyClass myFirstObject = new MyClass("obj1");
        MyClass mySecondObject = new MyClass("obj2");

        // The hash code of the two objects is the same, so they are considered equal
        // The equals() method is used to determine if the object is already in the set
        Set<MyClass> myClassSet = new HashSet<>();
        myClassSet.add(myFirstObject);
        myClassSet.add(mySecondObject);

        System.out.println(myClassSet);
    }

    static class MyClass {
        private String name;

        public MyClass(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj instanceof MyClass myClass) {
                return name.length() == myClass.name.length();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return name.length();
        }

        @Override
        public String toString() {
            return "MyClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
