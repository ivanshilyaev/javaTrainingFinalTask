package by.training.demothreads.assignment03;

public class Runner {
    public static void main(String[] args) {
        PriorThread min = new PriorThread("min");
        min.setPriority(Thread.MIN_PRIORITY);
        PriorThread max = new PriorThread("max");
        max.setPriority(Thread.MAX_PRIORITY);
        PriorThread norm = new PriorThread("norm");
        norm.setPriority(Thread.NORM_PRIORITY);
        min.start();
        max.start();
        norm.start();
    }
}
