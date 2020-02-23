package by.training.demothreads.assignment09;

public class Producer extends Thread {
    Store store;
    int product = 5;

    Producer(String name, Store store) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (product > 0) {
                product -= store.put();
                System.out.println("производителю " + getName() + " осталось произвести " + product +
                        " товар(ов)");
                sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("поток производителя прерван");
        }
    }
}
