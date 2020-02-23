package by.training.demothreads.assignment05;

import java.util.concurrent.TimeUnit;

public class ThreadToDisable implements Runnable {
    private boolean isAlive;

    public void disable() {
        isAlive = false;
    }

    public ThreadToDisable() {
        isAlive = true;
    }

    @Override
    public void run() {
        int counter = 0;
        while (isAlive) {
            System.out.println("Cycle " + ++counter);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " has finished its work");
    }
}
