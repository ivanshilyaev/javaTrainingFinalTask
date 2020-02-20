package by.training.demoThreads.assignment03;

public class PriorThread extends Thread {
    public PriorThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 50; ++i) {
            System.out.println(getName() + ": " + i);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
