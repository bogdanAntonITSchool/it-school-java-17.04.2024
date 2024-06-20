package exercises.collections.student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(20, "John", 9);
        Student student2 = new Student(18, "Danny", 8);
        Student student3 = new Student(20, "Johnny", 10);

        if (student1.equals(student2)) {
            System.out.println("The two students are equal");
        } else {
            System.out.println("The two students are not equal");
        }

        // Set.of() method is used to create an immutable set
        Set<Student> studentSet = new HashSet<>();

        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);

        System.out.println(studentSet);

        Comparator<Student> comparator = new StudentComparator();
//        Set<exercises.collections.student.Student> studentTreeSet = new TreeSet<>(comparator);
        // For the TreeSet without Comparator to work, the exercises.collections.student.Student class must implement the Comparable interface
        Set<Student> studentTreeSet = new TreeSet<>();

        studentTreeSet.add(student1);
        studentTreeSet.add(student2);
        studentTreeSet.add(student3);

        System.out.println(studentTreeSet);

        Map<Integer, String> students = new HashMap<>();
        students.put(1, "John");
        students.put(2, "Danny");
        System.out.println(students);

        students.put(1, "Johnny");
        System.out.println(students);

        students.putIfAbsent(3, "Bogdan");
        System.out.println(students);

        // create an immutable map
        Map<Integer, String> names =
                Map.of(1, "Vlad", 2, "Ionut", 3, "Mihai");

        students.putAll(names);
        System.out.println(students);

        Set<Map.Entry<Integer, String>> entries = students.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, student1);
        studentMap.put(2, student2);
        studentMap.put(3, student3);

        printMap(studentMap);

        Student brad = new Student(25, "Brad", 6);
        studentMap.put(2, brad);

        printMap(studentMap);

        List<Object> objects = new ArrayList<>();
        LinkedList<Object> objects1 = new LinkedList<>();

        // 1. Write a Java program to append the specified element to the end of a hash set.
        Set<String> hashSet = new HashSet<>();
        hashSet.add("element1");
        hashSet.add("element2");

    }

    private static void printMap(Map<Integer, Student> studentMap) {
        Set<Map.Entry<Integer, Student>> studentEntries = studentMap.entrySet();
        // Iterator is used to iterate through the elements of a collection
        Iterator<Map.Entry<Integer, Student>> iterator = studentEntries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Student> entry = iterator.next();
            iterator.next();
            iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (Map.Entry<Integer, Student> entry : studentEntries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }
}
