package lesson6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static lesson6.Main.task3;

@RunWith(Parameterized.class)
public class Task3Test {
    private int[] arr;
    private boolean result;

    public Task3Test(int[] arr, boolean result) {
        this.arr = arr;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {new int[]{1,1,1,4}, true},
                {new int[]{1,4,1}, true},
                {new int[]{1,1,1,1}, false},
                {new int[]{4}, false}
        });
    }

    @Test
    public void testTask3() {
        Assert.assertEquals(result, task3(arr, 1, 4));
    }
}
