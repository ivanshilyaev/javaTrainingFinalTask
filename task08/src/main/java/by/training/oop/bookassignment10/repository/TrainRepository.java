package by.training.oop.bookassignment10.repository;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.repository.exception.RepositoryException;

public interface TrainRepository {
    void add(Train train);

    void add(Train[] tmp);

    Train[] getAll();

    Train findByTrainNumber(int trainNumber) throws RepositoryException;
}
