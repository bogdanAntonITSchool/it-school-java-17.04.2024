package enums;

public class Main {
    public static void main(String[] args) {
        Flower flower = new Flower("Rose", Colors.RED);
        System.out.println(flower);

        Colors[] values = Colors.values();
        for (Colors color : values) {
            System.out.println(color.getLowerCaseColor());
        }

        Colors red = Colors.getEnum("yeLLow");
        System.out.println(red);
    }

    static class Flower {
//        private static final String[] colors = {"Red", "Green", "Blue", "Yellow", "White"};

        private final String name;
        private final Colors color;

        public Flower(String name, Colors color) {
            this.name = name;
            this.color = color;
//            for (String c : colors) {
//                if (c.equals(color)) {
//                    this.color = color;
//                    break;
//                }
//            }
        }

        @Override
        public String toString() {
            return "Flower{" +
                    "name='" + name + '\'' +
                    ", color=" + color.getLowerCaseColor() +
                    '}';
        }
    }
}
