package lesson1;

import lesson1.fruit_box.*;

public class Application {

    private static String[] arr = {"world", ",", "Hello", "!"};

    public static void main(String[] args) {
        //1
        printTaskHeader(1);
        Replacement<String> hello = new Replacement<>(arr);
        hello.replace(2, 0);

        Fruit[] arrFruits = {new Apple(), new Orange()};
        Replacement<Fruit> fruits = new Replacement<>(arrFruits);
        fruits.replace(0, 1);

        //2
        printTaskHeader(2);
        ArrayConverter<String> arrConverter = new ArrayConverter<>(arr);
        System.out.println(arrConverter.convert());

        //3
        printTaskHeader(3);
        System.out.println("Коробка №1 - 10 яблок");
        Box<Apple> box1 = new Box(1);
        for (int i = 0; i < 10; i++) {
            box1.addItem(new Apple());
        }
        box1.printBoxWeight();

        System.out.println("Коробка №2 - 10 апельсинов");
        Box<Orange> box2 = new Box(2);
        for (int i = 0; i < 10; i++) {
            box2.addItem(new Orange());
        }
        box2.printBoxWeight();

        System.out.println("Коробка №3 - 5 яблок");
        Box<Apple> box3 = new Box(3);
        for (int i = 0; i < 5; i++) {
            box3.addItem(new Apple());
        }
        box3.printBoxWeight();

        box1.printWeightComparatorResult(box2);

        box1.addAllItemsFromBox(box3);

        box1.printWeightComparatorResult(box2);
    }

    private static void printTaskHeader(int taskNumber) {
        System.out.printf("%n****task%s****%n", taskNumber);
    }
}
