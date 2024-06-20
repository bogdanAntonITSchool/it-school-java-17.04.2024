package generics.exercises.box;

public class ExerciseMain {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(10);

        Double[] doubles = {10.0, 20.0, 30.0};
        System.out.println(integerBox.getFirstElement(doubles));
        // System.out.println(integerBox.getFirstElementWithT(doubles));

        Integer[] integers = {10, 20, 30};
        System.out.println(integerBox.getFirstElementWithT(integers));

        System.out.println(integerBox);
    }

    static class Box<T> {
        private T value;

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "value=" + value +
                    '}';
        }

        // get the first element of the array using the generic type T
        public T getFirstElementWithT(T[] array) {
            if (array != null && array.length > 0) {
                return array[0];
            }
            return null;
        }

        // get the first element of the array using local generic type E
        public <E> E getFirstElement(E[] array) {
            if (array != null && array.length > 0) {
                return array[0];
            }
            return null;
        }
    }
}
