package by.training.demothreads.assignment11;

import java.util.concurrent.locks.ReentrantLock;

class CommonResource {
    int res = 0;
}

public class Runner11 {
    public static void main(String[] args) {
        CommonResource resource = new CommonResource();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 0; i < 3; ++i) {
            Thread thread = new Thread(new CountThread(resource, locker));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
