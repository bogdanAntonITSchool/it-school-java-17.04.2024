public class Student implements Comparable<Student> {
    private int age;
    private String name;
    private double grade;

    public Student(int age, String name, double grade) {
        this.age = age;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student student) {
            return age == student.age && name.equals(student.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return age + name.length();
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    // The compareTo method is overridden to compare the grade of the students
    @Override
    public int compareTo(Student o) {
        if (grade == o.grade) {
            return 0;
        } else if (grade > o.grade) {
            return 1;
        } else {
            return -1;
        }
    }
}
