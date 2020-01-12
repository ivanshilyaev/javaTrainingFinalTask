package by.training.final1.assignment02.controller;

import by.training.final1.assignment02.bean.Payment;
import by.training.final1.assignment02.service.PaymentService;
import by.training.final1.assignment02.view.ConsoleHelper;

public class Runner {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
        Payment payment = new Payment();
        PaymentService service = PaymentService.getInstance();
        for (int i = 0; i < 3; ++i) {
            String name = consoleHelper.readName();
            double price = consoleHelper.readPrice();
            double discount = consoleHelper.readDiscount();
            int quantity = consoleHelper.readQuantity();
            service.addCommodity(payment, name, price, discount, quantity);
        }
        consoleHelper.printMessage(service.getPaymentCheque(payment));
    }
}
