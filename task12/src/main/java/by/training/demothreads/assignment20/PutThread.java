package by.training.demothreads.assignment20;

import java.util.concurrent.Exchanger;

public class PutThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    PutThread(Exchanger ex) {
        this.exchanger = ex;
        message = "Hello Java!";
    }

    public void run() {
        try {
            message += " - It is the message from PutThread (" +
                    Thread.currentThread().getName() + ")";
            message = exchanger.exchange(message);
            System.out.println("PutThread " + Thread.currentThread().getName() + " получил: " + message);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}