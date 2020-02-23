package by.training.demothreads.assignment12;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Runner12 {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        Store store = new Store(locker);
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(consumer).start();
    }
}
