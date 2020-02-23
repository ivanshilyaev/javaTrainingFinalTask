package by.training.demothreads.assignment17;

import java.util.Random;

public class Runner17 {
    public static void main(String[] args) {
        Auction auction = new Auction();
        int startPrice = new Random().nextInt(100);
        for (int i = 0; i < Auction.BIDS_NUMBER; i++) {
            Bid thread = new Bid(i, startPrice, auction.getBarrier());
            auction.add(thread);
            thread.start();
        }
    }
}
