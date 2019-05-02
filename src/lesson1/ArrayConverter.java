package lesson1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ArrayConverter<T> {
    private T[] arr;

    ArrayConverter(T[] arr) {
        this.arr = arr;
    }

    List<T> convert() {
        List<T> arrList = new ArrayList<>();
        Collections.addAll(arrList, arr);
        return arrList;
    }
}
