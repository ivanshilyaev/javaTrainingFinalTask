package informationhandlinglight.training.by.service;

import informationhandlinglight.training.by.dao.DAOFactory;
import informationhandlinglight.training.by.dao.TextDAO;
import informationhandlinglight.training.by.dao.exception.DAOException;

public class ReadCommand {
    public String exec() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        TextDAO textDAO = daoFactory.getTextDao();
        try {
            return textDAO.readText();
        } catch (DAOException e) {
            throw new SecurityException("Unable to read data", e.getCause());
        }
    }
}
