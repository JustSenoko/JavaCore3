package lesson6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static lesson6.Main.task2;

public class Task2SingleTest {

    @Test(expected = RuntimeException.class)
    public void testTask2Exception() {
        int[] res = {1, 2, 3};
        int[] arrException = {1, 2, 3, 5};
        Assert.assertArrayEquals(res, task2(arrException, 4));
    }
}




