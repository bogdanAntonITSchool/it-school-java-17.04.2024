package solid.dip;

public abstract class Switch {

    abstract void operate();
}

class Fan extends Switch {

    @Override
    public void operate() {
        System.out.println("Fan is on");
    }
}

class Light extends Switch {

    @Override
    public void operate() {
        System.out.println("Light is on");
    }
}


// dependency inversion principle
class SwitchBoard {

    // inject the dependency
    private final Switch electricDevice;

    // constructor injection
    public SwitchBoard(Switch electricDevice) {
        this.electricDevice = electricDevice;
    }

    public void press() {
        electricDevice.operate();
    }
}
