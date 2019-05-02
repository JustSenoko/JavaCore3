package lesson1;

class Replacement<T> {
    private T[] arr;

    Replacement(T[] arr) {
        this.arr = arr;
    }

    void replace(int index1, int index2) {
        printArr();
        System.out.print(" -> ");
        if (index1 == index2) {
            printArr();
            System.out.println();
            return;
        }
        try {
            T buff = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = buff;
            printArr();
            System.out.println();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Неверно заданы индексы.");
        }

    }

    private void printArr() {
        for (T t : arr) {
            System.out.printf("%s ", t);
        }

    }

}
