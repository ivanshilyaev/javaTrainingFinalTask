package by.training.demothreads.assignment14;

import java.util.concurrent.Semaphore;

public class Runner14 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; ++i) {
            new Philosopher(semaphore, i).start();
        }
    }
}
