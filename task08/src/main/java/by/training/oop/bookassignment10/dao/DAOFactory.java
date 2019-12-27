package by.training.oop.bookassignment10.dao;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final CityReader cityReader = new CityReader();
    private final TrainReader trainReader = new TrainReader();
    private final TrainWriter trainWriter = new TrainWriter();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public CityReader getCityReader() {
        return cityReader;
    }

    public TrainReader getTrainReader() {
        return trainReader;
    }

    public TrainWriter getTrainWriter() {
        return trainWriter;
    }
}
