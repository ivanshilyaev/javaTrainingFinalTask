package by.training.demothreads.assignment07;

import java.io.IOException;

public class Runner07 {
    public static void main(String[] args) {
        Resource resource = null;
        try {
            resource = new Resource("/Users/ivansilaev/Desktop/out.txt");
            SyncThread thread1 = new SyncThread("thread1", resource);
            thread1.start();
            thread1.join();
            System.out.println("here");
            resource = new Resource("/Users/ivansilaev/Desktop/out.txt");
            SyncThread thread2 = new SyncThread("thread2", resource);
            thread2.start();
            thread2.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resource.close();
        }
    }
}
