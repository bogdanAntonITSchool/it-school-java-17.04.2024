package enums.exercise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the day: ");
        String string = scanner.nextLine();

        DayOfWeek day = DayOfWeek.getDay(string);
        switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("Working day");
            case SATURDAY, SUNDAY -> System.out.println("Weekend");
            case WRONG_DAY -> System.out.println("Wrong day");
        }
    }
}
