package lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private CountDownLatch cdlRaceFinish;
    private CyclicBarrier cbRaceStart;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    String getName() {
        return name;
    }
    int getSpeed() {
        return speed;
    }
    Car(Race race, int speed, CyclicBarrier cbRaceStart, CountDownLatch cdlRaceFinish) {
        this.race = race;
        this.speed = speed;
        this.cbRaceStart = cbRaceStart;
        this.cdlRaceFinish = cdlRaceFinish;

        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            if (cbRaceStart.getParties() == cbRaceStart.getNumberWaiting() + 1) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cbRaceStart.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdlRaceFinish.countDown();
    }
}

