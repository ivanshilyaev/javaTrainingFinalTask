package by.training.final1.assignment02.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Payment {
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
}
