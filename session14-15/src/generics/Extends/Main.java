package generics.Extends;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        System.out.println(sum(integers));

        List<Double> doubles = List.of(1.1, 2.2, 3.3, 4.4, 5.5);
        System.out.println(sum(doubles));
    }

    static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
