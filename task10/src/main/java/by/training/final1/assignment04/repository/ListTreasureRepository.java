package by.training.final1.assignment04.repository;

import by.training.final1.assignment04.bean.Cave;
import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.repository.exception.RepositoryException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ListTreasureRepository implements TreasureRepository {
    private static final ListTreasureRepository INSTANCE = new ListTreasureRepository();

    private ListTreasureRepository() {
    }

    public static ListTreasureRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(Cave cave, Treasure treasure) {
        cave.getTreasures().add(treasure);
        Collections.sort(cave.getTreasures());
    }

    @Override
    public void add(Cave cave, Treasure[] treasures) {
        for (Treasure treasure : treasures) {
            cave.getTreasures().add(treasure);
        }
        Collections.sort(cave.getTreasures());
    }

    @Override
    public List<Treasure> getAll(Cave cave) {
        return cave.getTreasures();
    }

    @Override
    public Treasure findByPrice(Cave cave, int price) throws RepositoryException {
        for (Treasure treasure : cave.getTreasures()) {
            if (treasure.getPrice() == price) {
                return treasure;
            }
        }
        throw new RepositoryException("No treasure with such price");
    }

    @Override
    public Treasure findMostExpensive(Cave cave) {
        int size = cave.getTreasures().size();
        return cave.getTreasures().get(size - 1);
    }

    @Override
    public List<Treasure> findBySetAmount(Cave cave, int amount) {
        int size = cave.getTreasures().size();
        int sum = 0;
        List<Treasure> treasures = new ArrayList<>();
        for (int i = size - 1; i >= 0; --i) {
            if (cave.getTreasures().get(i).getPrice() < amount - sum) {
                treasures.add(cave.getTreasures().get(i));
                sum += cave.getTreasures().get(i).getPrice();
            }
        }
        return treasures;
    }
}
