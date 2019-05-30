package lesson6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        printTaskHeader(1);
        int[] arr1 = {1,4,3,4,5,6};
        printArr(arr1);
        System.out.print("-> ");
        printArr(task2(arr1, 4));
        System.out.println();

        printTaskHeader(2);
        int[] arr2 = {4,4,4,4,4,4};
        printArr(arr2);
        System.out.print("-> ");
        System.out.println(task3(arr2, 1, 4));
    }

    static int[] task2(int[] arr, int number) throws RuntimeException {

        int index = find(arr, number);

        if (index == -1) {
            throw new RuntimeException();
        } else {
            return Arrays.copyOfRange(arr, index+1, arr.length);
        }
    }

    static boolean task3(int[] arr, int number1, int number2) {
        return (find(arr, number1) != -1 && find(arr, number2) != -1);
    }

    private static int find(int[] arr, int number) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    static private void printArr(int[] arr) {
        for (int t : arr) {
            System.out.printf("%d ", t);
        }
    }

    private static void printTaskHeader(int taskNumber) {
        System.out.printf("%n****task%s****%n", taskNumber);
    }
}
