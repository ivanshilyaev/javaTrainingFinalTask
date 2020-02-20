package by.training.demoThreads.assignment09;

public class ProducerConsumerApp {
    public static void main(String[] args) {
        Store store = new Store();
        new Producer("producer 1", store).start();
        new Consumer(store).start();
        new Producer("producer 2", store).start();
    }
}
