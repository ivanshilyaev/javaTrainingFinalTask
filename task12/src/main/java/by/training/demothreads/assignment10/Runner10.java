package by.training.demothreads.assignment10;

import java.util.concurrent.TimeUnit;

public class Runner10 {
    public static void main(String[] args) {
        Store store = new Store();
        new Producer(store).start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Consumer(store).start();
    }
}
