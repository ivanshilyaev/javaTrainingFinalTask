package by.training.demoThreads.assignment02;

public class Runner {
    public static void main(String[] args) {
        RunnablePerson alice = new RunnablePerson("Alice");
        RunnablePerson bob = new RunnablePerson("Bob");
        Thread aliceThread = new Thread(alice);
        Thread bobThread = new Thread(bob);
        aliceThread.setPriority(5);
        bobThread.setPriority(5);
        aliceThread.start();
        bobThread.start();
        try {
            aliceThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------Main has finished its work--------");
    }
}
