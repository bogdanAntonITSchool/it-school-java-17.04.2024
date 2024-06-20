package enums.exercise;

public enum DayOfWeek {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY, WRONG_DAY;

    public static DayOfWeek getDay(String day) {
        for (DayOfWeek d : DayOfWeek.values()) {
            if (d.name().equalsIgnoreCase(day)) {
                return d;
            }
        }
        return WRONG_DAY;
    }
}
