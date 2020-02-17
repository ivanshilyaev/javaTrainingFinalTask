package by.training.demoThreads.assignment09;

public class Producer extends Thread {
    Store store;
    int product = 5;

    Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (product > 0) {
                product -= store.put();
                System.out.println("производителю осталось произвести " + product +
                        " товар(ов)");
                sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("поток производителя прерван");
        }
    }
}
