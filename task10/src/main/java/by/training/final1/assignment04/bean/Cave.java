package by.training.final1.assignment04.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cave {
    private List<Treasure> treasures;
    public static final int QUANTITY = 100;

    public Cave() {
        treasures = new ArrayList<>();
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cave cave = (Cave) o;
        for (int i = 0; i < QUANTITY; ++i) {
            if (!treasures.get(i).equals(cave.treasures.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(treasures);
    }
}
