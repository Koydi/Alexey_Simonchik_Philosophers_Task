package by.epam.tc;

public class Spoon {
    private boolean isTaken = false;
    public synchronized void take() throws InterruptedException {
        while (isTaken) {
            wait();
        }
        isTaken = true;
    }

    public synchronized void put() {
        isTaken = false;
        notifyAll();
    }
}
