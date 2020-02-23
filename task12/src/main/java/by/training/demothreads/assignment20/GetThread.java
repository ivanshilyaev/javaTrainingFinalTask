package by.training.demothreads.assignment20;

import java.util.concurrent.Exchanger;

public class GetThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    GetThread(Exchanger ex) {
        this.exchanger = ex;
        message = "Привет мир!";
    }

    public void run() {
        try {
            message += " - It is the message from GetThread (" +
                    Thread.currentThread().getName() + ")";
            message = exchanger.exchange(message);
            System.out.println("GetThread " + Thread.currentThread().getName() + " получил: " + message);

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
