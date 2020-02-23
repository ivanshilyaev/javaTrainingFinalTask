package by.training.demothreads.assignment12;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int product;
    private ReentrantLock locker;
    private Condition condition;

    public Store(ReentrantLock locker) {
        this.locker = locker;
        condition = locker.newCondition();
    }

    public void get() {
        locker.lock();
        try {
            while (product < 1) {
                condition.await();
            }
            --product;
            System.out.println("Покупатель купил один товар");
            System.out.println("Товаров на складе - " + product);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public void put() {
        locker.lock();
        try {
            while (product >= 3) {
                condition.await();
            }
            ++product;
            System.out.println("Производитель произвёл один товар");
            System.out.println("Товаров на складе - " + product);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
