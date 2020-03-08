package by.training.demothreads.matrixelement.dao;

public final class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();
    private MatrixDAO fileMatrixDao = new FileMatrixDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public MatrixDAO getMatrixDao() {
        return fileMatrixDao;
    }
}
