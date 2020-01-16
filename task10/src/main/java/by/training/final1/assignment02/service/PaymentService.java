package by.training.final1.assignment02.service;

import by.training.final1.assignment02.bean.Commodity;
import by.training.final1.assignment02.bean.Payment;
import by.training.final1.assignment02.service.exception.ServiceException;
import by.training.final1.assignment02.service.validator.Validator;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;

public final class PaymentService {
    private static final PaymentService INSTANCE = new PaymentService();
    private static final String CHEQUE_DELIMITER = "==============================";

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
        Validator validator = new Validator();
        for (Commodity commodity : commodities) {
            validator.validate(commodity);
            payment.getBasket().addCommodity(commodity);
        }
    }

    /*
     * 5 per cent discount,
     * but not more than 2$
     */
    private double calculateDiscount(Commodity commodity) {
        return Math.min(2.0, PaymentService.round(0.05 * commodity.getPrice(), 2));
    }

    public double calculateAmount(Payment payment, Commodity commodity) {
        return (commodity.getPrice() - calculateDiscount(commodity))
                * payment.getBasket().getShoppingList().get(commodity);
    }

    public double calculateTotalAmount(Payment payment) {
        double total = 0;
        for (Commodity commodity : payment.getBasket().getShoppingList().keySet()) {
            total += calculateAmount(payment, commodity);
        }
        return total;
    }

    public String getPaymentCheque(Payment payment) {
        StringBuilder builder = new StringBuilder();
        builder.append(CHEQUE_DELIMITER).append('\n');
        builder.append("CHEQUE").append('\n');
        builder.append(CHEQUE_DELIMITER).append('\n');
        for (Commodity commodity : payment.getBasket().getShoppingList().keySet()) {
            builder.append("Barcode: ").append(commodity.getBarcode()).append('\n');
            builder.append("Name: ").append(commodity.getName()).append('\n');
            builder.append("Price: ").append(commodity.getPrice()).append('\n');
            builder.append("Discount: ").append(calculateDiscount(commodity)).append('\n');
            builder.append("Quantity: ").append(payment.getBasket().getShoppingList().get(commodity)).append('\n');
            builder.append("Amount: ").append(calculateAmount(payment, commodity)).append('\n');
            builder.append(CHEQUE_DELIMITER).append('\n');
        }
        builder.append("Total: ").append(calculateTotalAmount(payment)).append('\n');
        builder.append(CHEQUE_DELIMITER).append('\n');
        builder.append("Cashier: ").append(payment.getCashierName()).append('\n');
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        builder.append("Time: ").append(formatter.format(payment.getPurchaseTime())).append('\n');
        builder.append(CHEQUE_DELIMITER).append('\n');
        return builder.toString();
    }
}
