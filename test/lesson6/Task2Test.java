package lesson6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static lesson6.Main.task2;

@RunWith(Parameterized.class)
public class Task2Test {
    private int[] arr;
    private int[] result;

    public Task2Test(int[] arr, int[] result) {
        this.arr = arr;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}},
                {new int[]{1, 4, 4, 4, 6, 8, 4}, new int[]{}},
                {new int[]{5, 2, 4, 7, 7, 7}, new int[]{7, 7, 7}},
                {new int[]{3, 4, 5}, new int[]{5}}
        });
    }

    @Test
    public void testTask2() {
        Assert.assertArrayEquals(result, task2(arr, 4));
    }
}




