package lesson7;

import lesson7.annotations.AfterSuite;
import lesson7.annotations.BeforeSuite;
import lesson7.annotations.Test;

/*
Тестируется пример (3+5)*(7-2)/4
 */
public class CalculatorTest {
    private static float memory1;
    private static float memory2;
    private static boolean success = true;

    @BeforeSuite
    public void init() {
        System.out.println("Тестируется пример (3+5)*(7-2)/4");
        memory1 = 0;
        memory2 = 0;
    }

    @AfterSuite
    public void finish() {
        System.out.printf("Тестирование окончено %s%n", success ? "успешно" : "с ошибками");
    }

    @Test(priority = 1)
    public void plusTest() {
        memory1 = Calculator.plus(3, 5);
        testResult(8, memory1);
    }

    @Test(priority = 1)
    public void minusTest() {
        memory2 = Calculator.minus(7, 2);
        testResult(5, memory2);
    }

    @Test(priority = 2)
    public void multiplyTest() {
        float res = Calculator.multiply(memory1, memory2);
        testResult(memory1 * memory2, res);
        memory2 = res;
    }

    @Test(priority = 2)
    public void divideTest() {
        float res = Calculator.divide(memory2, 4);
        testResult(memory2 / 4, res);
        memory2 = res;
    }

    @Test(priority = 10)
    public void checkResult() {
        testResult(10, memory2);
    }

    private void testResult(float expected, float actual) {
        if (expected == actual) {
            System.out.println("пройден успешно");
        } else {
            System.out.printf("не пройден: expected %.1f, actual %.1f%n", expected, actual);
            success = false;
        }
    }

}
