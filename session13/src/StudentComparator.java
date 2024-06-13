import java.util.Comparator;

// The StudentComparator class implements the Comparator interface
public class StudentComparator implements Comparator<Student> {

    // 0 - both elements are equal
    // 1 - the first element is greater than the second element
    // -1 - the first element is smaller than the second element
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGrade() == o2.getGrade()) {
            return 0;
        } else if (o1.getGrade() > o2.getGrade()) {
            return 1;
        } else {
            return -1;
        }
    }
}
