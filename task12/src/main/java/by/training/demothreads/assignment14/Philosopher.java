package by.training.demothreads.assignment14;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    Semaphore semaphore;
    int num = 0;
    int id;

    public Philosopher(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (num < 3) {
                semaphore.acquire();
                System.out.println("Философ " + id + " садится за стол");
                sleep(500);
                num++;
                System.out.println("Философ " + id + " выходит из-за стола");
                semaphore.release();
                sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
