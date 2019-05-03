package lesson1;

import lesson1.fruit_box.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    private static String[] arrSample1 = {"world", ",", "Hello", "!"};
    private static Integer[] arrSample2 = {1, 3, 2, 4};

    public static void main(String[] args) {
        //1
        printTaskHeader(1);
        replace(arrSample1, 2, 0);
        replace(arrSample2, 1, 2);

        //2
        printTaskHeader(2);
        System.out.println(convertToList(arrSample1));
        System.out.println(convertToList(arrSample2));

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

    private static <T> void replace(T[] arr, int index1, int index2) {
        printArr(arr);
        System.out.print(" -> ");
        if (index1 == index2) {
            printArr(arr);
            System.out.println();
            return;
        }
        try {
            T buff = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = buff;
            printArr(arr);
            System.out.println();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Неверно заданы индексы.");
        }

    }

    private static <T> List<T> convertToList(T[] ar) {
        List<T> arrList = new ArrayList<>();
        Collections.addAll(arrList, ar);
        return arrList;
    }

    static private <T> void printArr(T[] arr) {
        for (T t : arr) {
            System.out.printf("%s ", t);
        }

    }

    private static void printTaskHeader(int taskNumber) {
        System.out.printf("%n****task%s****%n", taskNumber);
    }
}
