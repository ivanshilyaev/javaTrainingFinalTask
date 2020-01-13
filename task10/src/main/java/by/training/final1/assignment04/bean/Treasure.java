package by.training.final1.assignment04.bean;

import java.util.Objects;

public class Treasure implements Comparable<Treasure> {
    private int price;

    public Treasure(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return price == treasure.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "price = " + price +
                '}';
    }

    @Override
    public int compareTo(Treasure o) {
        return price - o.price;
    }
}
