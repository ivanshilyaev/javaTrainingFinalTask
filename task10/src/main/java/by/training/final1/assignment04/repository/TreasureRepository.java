package by.training.final1.assignment04.repository;

import by.training.final1.assignment04.bean.Cave;
import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.repository.exception.RepositoryException;

import java.util.List;

public interface TreasureRepository {
    void add(Cave cave, Treasure treasure);

    void add(Cave cave, Treasure[] treasures);

    List<Treasure> getAll(Cave cave);

    Treasure findByPrice(Cave cave, int price) throws RepositoryException;

    Treasure findMostExpensive(Cave cave);

    List<Treasure> findBySetAmount(Cave cave, int amount);
}
