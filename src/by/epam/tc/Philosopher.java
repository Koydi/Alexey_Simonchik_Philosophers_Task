package by.epam.tc;

public class Philosopher implements Runnable {
    private Spoon rightSpoon;
    private Spoon leftSpoon;
    private byte id;

    public Philosopher(Spoon rightSpoon, Spoon leftSpoon, byte id) {
        this.rightSpoon = rightSpoon;
        this.leftSpoon = leftSpoon;
        this.id = id;
    }

    private void thinking() throws InterruptedException {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new InterruptedException();
        }
    }

    private void eating() throws InterruptedException {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new InterruptedException();
        }
    }

    @Override
    public void run() {
        boolean isRunning = true;
        while(isRunning) {
            try {
                thinking();
                leftSpoon.take();
                rightSpoon.take();
                eating();
                System.out.println("eating " + id);
                leftSpoon.put();
                rightSpoon.put();
            } catch (InterruptedException e) {
                isRunning = false;
            }

        }
    }
}
