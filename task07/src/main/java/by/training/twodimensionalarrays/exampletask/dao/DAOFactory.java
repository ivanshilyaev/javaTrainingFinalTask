package by.training.twodimensionalarrays.exampletask.dao;

public class DAOFactory {
    public static final DAOFactory instance = new DAOFactory();

    private final MatrixReader matrixReader = new MatrixReader();
    private final MatrixWriter matrixWriter = new MatrixWriter();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public MatrixReader getMatrixReader() {
        return matrixReader;
    }

    public MatrixWriter getMatrixWriter() {
        return matrixWriter;
    }
}
