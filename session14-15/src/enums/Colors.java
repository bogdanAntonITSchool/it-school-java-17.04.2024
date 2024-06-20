package enums;

public enum Colors {
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    YELLOW("yellow"),
    WHITE("white");

    private final String lowerCaseColor;

    Colors(String lowerCaseColor) {
        this.lowerCaseColor = lowerCaseColor;
    }

    public String getLowerCaseColor() {
        return lowerCaseColor;
    }

    public static Colors getEnum(String color) {
        for (Colors c : Colors.values()) {
            if (c.name().equalsIgnoreCase(color)) {
                return c;
            }
        }
        return null;
    }
}
