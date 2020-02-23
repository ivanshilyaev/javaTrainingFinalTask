package by.training.demothreads.assignment11;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {
    CommonResource resource;
    ReentrantLock locker;

    public CountThread(CommonResource resource, ReentrantLock reentrantLock) {
        this.resource = resource;
        this.locker = reentrantLock;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            resource.res = 0;
            for (int i = 0; i < 5; ++i) {
                System.out.println(Thread.currentThread().getName() + " " + ++resource.res);
            }
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
