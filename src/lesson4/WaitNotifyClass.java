package lesson4;

public class WaitNotifyClass {
    private static final int REPEAT_COUNT = 5;
    private static final char[] ORDER = {'A', 'B', 'C'};
    private static volatile int index = 0;

    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        Thread[] threads = new Thread[ORDER.length];
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> printLetter(ORDER[finalI]));
            threads[i].start();
        }
    }

    private static void printLetter(char letter) {
        synchronized (MONITOR) {
            try {
                for (int i = 0; i < REPEAT_COUNT; i++) {
                    while (ORDER[index] != letter) {
                        MONITOR.wait();
                    }
                    System.out.print(letter);
                    nextIndex();
                    MONITOR.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void nextIndex() {
        int i = index + 1;
        if (i >= ORDER.length) {
            i = 0;
        }
        index = i;
    }

}
