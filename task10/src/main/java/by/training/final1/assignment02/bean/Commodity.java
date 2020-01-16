package by.training.final1.assignment02.bean;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Commodity {
    private String barcode;
    private String name;
    private double price;

    public Commodity(String name, double price) {
        barcode = generateBarcode();
        this.name = name;
        this.price = price;
    }

    public Commodity(String barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
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

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return Double.compare(commodity.price, price) == 0 &&
                barcode.equals(commodity.barcode) &&
                name.equals(commodity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, name, price);
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "barcode = '" + barcode + '\'' +
                ", name = '" + name + '\'' +
                ", price = " + String.format("%.2f", price) +
                '}';
    }
}
