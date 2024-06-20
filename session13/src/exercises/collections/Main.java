package exercises.collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        4. Create a class called Person with the following properties: String name; int age; String job.
//        Create multiple instances of type Person and add them to a Map (the key can be an integer).
//        Please iterate over the map and print the name of each person.
        Person personOne = new Person("John", 30, "Developer");
        Person personTwo = new Person("Daniel", 25, "Musician");
        Person personThree = new Person("Michael", 35, "Manager");

        // create a map with the key as an integer and the value as a Person object
        // immutable map
        Map<Integer, Person> personMap =
                Map.of(1, personOne, 2, personTwo, 3, personThree);

        // some other lines of code...

//        personMap.put(4, new Person("Alice", 28, "Designer")); // UnsupportedOperationException

        Map<Integer, Person> personMapMutable = new HashMap<>();
        personMapMutable.put(1, personOne);
        personMapMutable.put(2, personTwo);
        personMapMutable.put(3, personThree);

        Set<Map.Entry<Integer, Person>> entries = personMapMutable.entrySet();

        for (Map.Entry<Integer, Person> entry : entries) {
            System.out.println(entry.getValue().name);
        }

//        var sum = computeSum(2, 3);
//
//        sum += 10;
//        System.out.println(sum);

        Bird eagle = new Eagle();
        Bird chicken = new Chicken();

        List<Bird> birds = new ArrayList<>();
        birds.add(eagle);
        birds.add(chicken);

        for (Bird b : birds) {
            b.eat();
        }
    }

    //      Bird
    //     /    \
    // Eagle    Chicken

    //          Bird
    //         /    \
    // FlyingBird NonFlyingBird
    //    /            \
    // Eagle         Chicken

    abstract static class Bird {
        public abstract void eat();
    }

    abstract static class FlyingBird extends Bird {
        public void fly() {
            System.out.println("The bird is flying");
        }
    }

    abstract static class NonFlyingBird extends Bird {
        public void walk() {
            System.out.println("The bird is walking");
        }
    }

    static class Eagle extends FlyingBird {
        @Override
        public void fly() {
            System.out.println("The eagle is flying");
        }

        @Override
        public void eat() {
            System.out.println("The eagle is eating");
        }
    }

    static class Chicken extends NonFlyingBird {
        @Override
        public void walk() {
            System.out.println("The chicken is walking");
        }

        @Override
        public void eat() {
            System.out.println("The chicken is eating");
        }
    }

    private static String computeSum(int a, int b) {
        return String.valueOf(a + b);
    }

    static class Person {
        private final String name;
        private final int age;
        private final String job;

        public Person(String name, int age, String job) {
            this.name = name;
            this.age = age;
            this.job = job;
        }
    }
}
