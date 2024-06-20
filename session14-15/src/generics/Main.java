package generics;

public class Main {

    public static void main(String[] args) {
//        MyClass<Integer> myClass = new MyClass<>(12);
//
//        System.out.println(myClass.getValue());
//        myClass.doSomeLogic(15);
//
//        MyGenericClass<Integer, Integer> myGenericClass =
//                new MyGenericClass<>(12, 15);
//        myGenericClass.printSum();
//
//        MyGenericClass<String, String> myGenericClass2 =
//                new MyGenericClass<>("Hello", "World");
//        myGenericClass2.printSum();
//
//        MyGenericClass<List, Map> myGenericClass3 = new MyGenericClass<>(List.of(), Map.of());
//        myGenericClass3.printSum();

        Phone phone = new Phone("Samsung", "Galaxy S10");
        Box<Phone> phoneBox = new Box<>(phone);
        phoneBox.printBoxContent();

        Shoe nikeShoe = new Shoe("Nike", "Air Max");
        Box<Shoe> shoeBox = new Box<>(nikeShoe);
        shoeBox.printBoxContent();
    }
}
