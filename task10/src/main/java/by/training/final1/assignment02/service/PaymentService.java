package by.training.final1.assignment02.service;

import by.training.final1.assignment02.bean.Payment;

public final class PaymentService {
    private static final PaymentService INSTANCE = new PaymentService();

    private PaymentService() {
    }

    public static PaymentService getInstance() {
        return INSTANCE;
    }

    public void addCommodity(Payment payment, String name, double price, double discount) {
        payment.addCommodity(name, price, discount);
    }

    public void addCommodity(Payment payment, String name, double price, double discount,
                             int quantity) {
        payment.addCommodity(name, price, discount, quantity);
    }
}
