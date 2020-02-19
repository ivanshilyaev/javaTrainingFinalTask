package by.training.demoThreads.assignment09;

public class Store {
    int counter = 0;
    final int N = 0;

    synchronized int put() {
        if (counter <= N) {
            ++counter;
            System.out.println("склад имеет " + counter + " товар(ов)");
            return 1;
        }
        return 0;
    }

    synchronized int get() {
        if (counter > 0) {
            --counter;
            System.out.println("склад имеет " + counter + " товар(ов)");
            return 1;
        }
        return 0;
    }
}