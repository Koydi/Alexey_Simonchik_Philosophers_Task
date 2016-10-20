package by.epam.tc;


import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUMBER = 5;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Spoon[] spoons = new Spoon[NUMBER];
        for (byte i = 0; i < NUMBER; i++) {
            spoons[i] = new Spoon();
        }
        for (byte i = 0; i < NUMBER; i++) {
            if (i < NUMBER - 1) {
                executorService.execute(new Philosopher(spoons[i], spoons[i + 1], i));
            } else {
                executorService.execute(new Philosopher(spoons[i], spoons[0], i));
            }
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdownNow();

        }
    }
}
