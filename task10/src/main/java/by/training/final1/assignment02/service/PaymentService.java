package by.training.final1.assignment02.service;

import by.training.final1.assignment02.bean.Commodity;
import by.training.final1.assignment02.bean.Payment;
import by.training.final1.assignment02.service.exception.ServiceException;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

public final class PaymentService {
    private static final PaymentService INSTANCE = new PaymentService();

    private PaymentService() {
    }

    public static PaymentService getInstance() {
        return INSTANCE;
    }

    public static double round(double value, int places) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void addCommodities(Payment payment, File file) throws ServiceException {
        ReadCommoditiesCommand command = ReadCommoditiesCommand.getInstance();
        Commodity[] commodities = command.read(file);
        // validating!
        for (Commodity commodity : commodities) {
            payment.getBasket().addCommodity(commodity);
        }
    }

    public String getPaymentCheque(Payment payment) {
        return payment.getCheque();
    }
}
