package by.training.final1.assignment04.dao;

public final class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();
    private final TreasuresReader treasuresReader = new TreasuresReader();
    private final TreasuresWriter treasuresWriter = new TreasuresWriter();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public TreasuresReader getTreasuresReader() {
        return treasuresReader;
    }

    public TreasuresWriter getTreasuresWriter() {
        return treasuresWriter;
    }
}
