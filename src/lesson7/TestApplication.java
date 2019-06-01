package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestApplication {
    private static int priorityCount = 10;
    private static Method[][] methodsOrder = new Method[priorityCount + 2][100];
    private static int[] index = new int[priorityCount + 2];
    //0 - BeforeSuite
    //1-10 - Test priority
    //11 - AfterSuite

    public static void main(String[] args) {
        start(CalculatorTest.class);
    }

    private static <T> T init(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        for (int i = 0; i < priorityCount + 1; i++) {
            index[i] = 0;
        }
        return clazz.newInstance();
    }

    private static <T> void start(Class<T> clazz) {
        T instance;
        try {
            instance = init(clazz);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return;
        }
        try {
            fillMethodsOrder(clazz);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return;
        }

        for (int i = 0; i < priorityCount + 2; i++) {
            for (int j = 0; j < methodsOrder[i].length; j++) {
                if (methodsOrder[i][j] == null) {
                    break;
                }
                invokeMethod(methodsOrder[i][j], instance, i > 0 && i <= priorityCount);
            }
        }
    }

    private static <T> void fillMethodsOrder(Class<T> clazz) throws RuntimeException {
        for (Method method : clazz.getDeclaredMethods()) {
            int order;
            if (method.isAnnotationPresent(lesson7.annotations.BeforeSuite.class)) {
                order = 0;
            } else if (method.isAnnotationPresent(lesson7.annotations.Test.class)) {
                order = method.getAnnotation(lesson7.annotations.Test.class).priority();
            } else if (method.isAnnotationPresent(lesson7.annotations.AfterSuite.class)) {
                order = priorityCount + 1;
            } else {
                continue;
            }
            addMethod(method, order);
        }
    }

    private static void addMethod(Method method, int order) throws RuntimeException {
        if ((order == 0 || order == priorityCount + 1) && index[order] > 0) {
            System.err.printf("В тестируемом классе более одного метода с аннотацией %s%n",
                    order == 0 ? "@BeforeSuite" : "AfterSuite");
            throw new RuntimeException();
        }
        methodsOrder[order][index[order]] = method;
        index[order]++;
    }

    private static <T> void invokeMethod(Method method, T instance, boolean printTestName) {
        if (printTestName) {
            System.out.printf("Тест метода %s ", method.getName());
        }
        if (method.getParameterCount() > 0) {
            System.out.println("Для метода %s необходимо передать параметры. Автоматическое выполнение невозможно");
            return;
        }
        try {
            method.invoke(instance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
