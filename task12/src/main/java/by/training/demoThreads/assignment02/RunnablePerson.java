package by.training.demoThreads.assignment02;

import java.util.concurrent.TimeUnit;

public class RunnablePerson extends Person implements Runnable {
    public RunnablePerson(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(getName() + ": Hello World");
        }
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
