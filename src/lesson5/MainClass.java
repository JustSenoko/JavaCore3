package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    private static final int CARS_COUNT = 4;
    private static CyclicBarrier cbRaceStart = new CyclicBarrier(CARS_COUNT);
    private static CountDownLatch cdlRaceFinish = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT/2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cbRaceStart, cdlRaceFinish);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        try {
            cdlRaceFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка была прервана!!!");
            e.printStackTrace();
        }
    }
}
