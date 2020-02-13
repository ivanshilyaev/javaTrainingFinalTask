package by.training.demoThreads.assignment01;

public class DemoThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        DemoThread demoThread = new DemoThread();
        demoThread.start();
    }
}
