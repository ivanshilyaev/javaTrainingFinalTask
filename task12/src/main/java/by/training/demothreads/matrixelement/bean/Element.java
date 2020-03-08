package by.training.demothreads.matrixelement.bean;

import java.util.concurrent.locks.ReentrantLock;

public class Element {
    private int value;
    private ReentrantLock locker;
    private int numberOfChanges;

    public Element(int value) {
        this.value = value;
        locker = new ReentrantLock();
        numberOfChanges = 0;
    }

    public void setValue(int value) {
        locker.lock();
        if (numberOfChanges == 0) {
            this.value = value;
            ++numberOfChanges;
        }
        locker.unlock();
    }

    public int getValue() {
        return value;
    }

    public int getNumberOfChanges() {
        return numberOfChanges;
    }
}
