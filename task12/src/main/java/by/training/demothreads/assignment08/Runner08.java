package by.training.demothreads.assignment08;

import java.util.concurrent.TimeUnit;

public class Runner08 {
    private static int counter = 0;

    public static void main(String[] args) {
        final StringBuilder builder = new StringBuilder();
        new Thread(() -> {
            synchronized (builder) {
                do {
                    builder.append("A");
                    System.out.println(builder);
                    try {
                        TimeUnit.MILLISECONDS.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (++counter < 3);
            }
        }).start();
        new Thread(() -> {
            synchronized (builder) {
                do {
                    builder.append("B");
                    System.out.println(builder);
                    try {
                        TimeUnit.MILLISECONDS.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (++counter < 6);
            }
        }).start();
    }
}
