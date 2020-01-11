package by.training.final1.assignment02.bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Payment {
    private List<Commodity> shoppingList;

    public Payment() {
        shoppingList = new LinkedList<>();
    }

    public class Commodity {
        private String barcode;
        private String name;
        private double price;
        private double discount;
        private int quantity;
        private double amount;

        public Commodity(String name, double price, double discount) {
            barcode = generateBarcode();
            this.name = name;
            this.price = price;
            this.discount = discount;
            quantity = 1;
            amount = calculateAmount();
        }

        public Commodity(String name, double price, double discount, int quantity) {
            barcode = generateBarcode();
            this.name = name;
            this.price = price;
            this.discount = discount;
            this.quantity = quantity;
            amount = calculateAmount();
        }

        public String generateBarcode() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 3; ++i) {
                builder.append((char) ThreadLocalRandom.current().nextInt(65, 91));
            }
            builder.append("-");
            for (int i = 0; i < 3; ++i) {
                builder.append((char) ThreadLocalRandom.current().nextInt(97, 123));
            }
            builder.append("-");
            for (int i = 0; i < 4; ++i) {
                builder.append(ThreadLocalRandom.current().nextInt(1, 10));
            }
            return builder.toString();
        }

        public double calculateAmount() {
            return quantity * (price - discount);
        }

        public String getBarcode() {
            return barcode;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public double getDiscount() {
            return discount;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getAmount() {
            return amount;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Commodity commodity = (Commodity) o;
            return Double.compare(commodity.price, price) == 0 &&
                    Double.compare(commodity.discount, discount) == 0 &&
                    quantity == commodity.quantity &&
                    Double.compare(commodity.amount, amount) == 0 &&
                    barcode.equals(commodity.barcode) &&
                    name.equals(commodity.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(barcode, name, price, discount, quantity, amount);
        }

        @Override
        public String toString() {
            return "Commodity{" +
                    "barcode = '" + barcode + '\'' +
                    ", name = '" + name + '\'' +
                    ", price = " + String.format("%.2f", price) +
                    ", discount = " + String.format("%.2f", discount) +
                    ", quantity = " + quantity +
                    ", amount = " + String.format("%.2f", amount) +
                    '}';
        }
    }

    public void addCommodity(String name, double price, double discount) {
        Commodity commodity = new Commodity(name, price, discount);
        shoppingList.add(commodity);
    }

    public void printShoppingList() {
        for (Commodity commodity : shoppingList) {
            System.out.println(commodity);
        }
    }
}
