package lesson1.fruit_box;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> items = new ArrayList<>();
    private int number;

    public Box(int number) {
        this.number = number;
    }

    public void addAllItemsFromBox(Box<T> box) {
        items.addAll(box.getItems());
        box.empty();
        System.out.printf("Пересыпали фрукты из корзины №%d в №%d%n", box.getNumber(), getNumber());
    }

    public void addItem(T item) {
        items.add(item);
    }

    private float getWeight() {
        float weight = 0;
        for (T item : items) {
            weight += item.getWeight();
        }
        return weight;
    }

    private boolean compare(Box<?> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.0000001;
    }

    private List<T> getItems() {
        return this.items;
    }

    private void empty() {
        items.clear();
    }

    private int getNumber() {
        return number;
    }

    public void printWeightComparatorResult(Box<?> box) {
        boolean result = compare(box);
        System.out.printf("Коробка №%d и №%d весят %s%n", getNumber(), box.getNumber(), (result ? "одинаково" : "по-разному"));
    }
    public void printBoxWeight() {
        System.out.printf("Вес коробки с яблоками №%d:  %3f%n", getNumber(), getWeight());
    }
}
