package by.training.final1.assignment02.controller;

import by.training.final1.assignment02.bean.Payment;

public class Runner {
    public static void main(String[] args) {
        Payment payment = new Payment();
        for (int i = 0; i < 10; ++i) {
            payment.addCommodity("num" + i, i * 1.89, i * 0.07);
        }
        payment.printShoppingList();
    }
}
