package solid.isp;

public interface Worker {
    void work();
}

interface Human {
    void eat();
    void drink();
}

class HumanWorker implements Worker, Human {
    @Override
    public void work() {
        System.out.println("HumanWorker is working");
    }

    @Override
    public void eat() {
        System.out.println("HumanWorker is eating");
    }

    @Override
    public void drink() {
        System.out.println("HumanWorker is drinking");
    }
}

class RobotWorker implements Worker {
    @Override
    public void work() {
        System.out.println("RobotWorker is working");
    }
}
