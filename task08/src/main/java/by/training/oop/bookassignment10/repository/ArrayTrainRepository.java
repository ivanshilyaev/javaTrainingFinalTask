package by.training.oop.bookassignment10.repository;

import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.repository.exception.RepositoryException;

public final class ArrayTrainRepository implements TrainRepository {
    private static final ArrayTrainRepository instance = new ArrayTrainRepository();
    private Train[] trains = new Train[0];

    private ArrayTrainRepository() {
    }

    public static ArrayTrainRepository getInstance() {
        return instance;
    }

    @Override
    public void add(Train train) {
        Train[] array = new Train[trains.length + 1];
        System.arraycopy(trains, 0, array, 0, trains.length);
        array[trains.length] = train;
        trains = array;
    }

    @Override
    public void add(Train[] tmp) {
        Train[] array = new Train[trains.length + tmp.length];
        System.arraycopy(trains, 0, array, 0, trains.length);
        System.arraycopy(tmp, 0, array, trains.length, tmp.length);
        trains = array;
    }

    @Override
    public Train[] getAll() {
        return trains;
    }

    @Override
    public Train findByTrainNumber(int trainNumber) throws RepositoryException {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        throw new RepositoryException("No such element");
    }
}
