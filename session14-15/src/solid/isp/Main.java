package solid.isp;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Worker robotWorker = new RobotWorker();
        Worker humanWorker = new HumanWorker();

        List<Worker> workers = List.of(robotWorker, humanWorker);
        for (Worker worker : workers) {
            worker.work();
            if (worker instanceof Human) {
                Human human = (Human) worker;

                human.eat();
                human.drink();
            }
            System.out.println("----------------------");
        }
    }
}
