package solid.dip;

public class Main {

    public static void main(String[] args) {
        Fan fan = new Fan();
        // some code with fan...

        SwitchBoard switchBoard = new SwitchBoard(fan);
        switchBoard.press();

        Light light = new Light();
        // some code with light...

        SwitchBoard switchBoard1 = new SwitchBoard(light);
        switchBoard1.press();
    }
}
