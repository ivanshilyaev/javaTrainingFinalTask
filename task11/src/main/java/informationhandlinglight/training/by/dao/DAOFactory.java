package informationhandlinglight.training.by.dao;

public final class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private final TextDAO fileTextDao = new FileTextDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public TextDAO getTextDao() {
        return fileTextDao;
    }
}
