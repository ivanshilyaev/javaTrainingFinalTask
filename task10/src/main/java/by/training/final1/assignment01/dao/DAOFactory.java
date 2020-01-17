package by.training.final1.assignment01.dao;

public final class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();
    private final FileReader fileReader = new FileReader();
    private final FileWriter fileWriter = new FileWriter();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }
}
