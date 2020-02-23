package by.training.demothreads.assignment05;

import java.util.concurrent.TimeUnit;

public class Runner05 {
    public static void main(String[] args) {
        ThreadToDisable threadToDisable = new ThreadToDisable();
        Thread thread = new Thread(threadToDisable, "Thread 1");
        thread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadToDisable.disable();
        System.out.println(Thread.currentThread().getName() + " has finished its work");
    }
}
