package by.training.final1.assignment02.bean;

import by.training.final1.assignment02.service.PaymentService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Payment {
    private static final String CHEQUE_DELIMITER = "==============================";
    private Basket basket;
    private String cashierName;
    private Date purchaseTime;

    public class Basket {
        /*
         * contains quantity of each commodity
         */
        private Map<Commodity, Integer> shoppingList;

        public Map<Commodity, Integer> getShoppingList() {
            return shoppingList;
        }

        public Basket() {
            shoppingList = new HashMap<>();
        }

        public void addCommodity(Commodity commodity) {
            if (shoppingList.containsKey(commodity)) {
                shoppingList.put(commodity, shoppingList.get(commodity) + 1);
            } else {
                shoppingList.put(commodity, 1);
            }
        }
    }

    public Payment() {
        basket = new Basket();
        cashierName = "Shilyaev I.V.";
        purchaseTime = new Date();
    }

    public Basket getBasket() {
        return basket;
    }

    public String getCashierName() {
        return cashierName;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }


    // services should do all of it!!!

    /*
     * 5 per cent discount,
     * but not more than 2$
     */
    private double calculateDiscount(Commodity commodity) {
        return Math.min(2.0, PaymentService.round(0.05 * commodity.getPrice(), 2));
    }

    public double calculateAmount(Commodity commodity) {
        return (commodity.getPrice() - calculateDiscount(commodity))
                * basket.shoppingList.get(commodity);
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (Commodity commodity : basket.shoppingList.keySet()) {
            total += calculateAmount(commodity);
        }
        return total;
    }

    public String getCheque() {
        StringBuilder builder = new StringBuilder();
        builder.append(CHEQUE_DELIMITER).append('\n');
        builder.append("CHEQUE").append('\n');
        builder.append(CHEQUE_DELIMITER).append('\n');
        for (Commodity commodity : basket.shoppingList.keySet()) {
            builder.append("Barcode: ").append(commodity.getBarcode()).append('\n');
            builder.append("Name: ").append(commodity.getName()).append('\n');
            builder.append("Price: ").append(commodity.getPrice()).append('\n');
            builder.append("Discount: ").append(calculateDiscount(commodity)).append('\n');
            builder.append("Quantity: ").append(basket.shoppingList.get(commodity)).append('\n');
            builder.append("Amount: ").append(calculateAmount(commodity)).append('\n');
            builder.append(CHEQUE_DELIMITER).append('\n');
        }
        builder.append("Total: ").append(calculateTotalAmount()).append('\n');
        builder.append(CHEQUE_DELIMITER).append('\n');
        builder.append("Cashier: ").append(cashierName).append('\n');
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        builder.append("Time: ").append(formatter.format(purchaseTime)).append('\n');
        builder.append(CHEQUE_DELIMITER).append('\n');
        return builder.toString();
    }
}
