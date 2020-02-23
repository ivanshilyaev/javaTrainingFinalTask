package informationhandlinglight.training.by.service;

import informationhandlinglight.training.by.dao.DAOFactory;
import informationhandlinglight.training.by.dao.TextDAO;
import informationhandlinglight.training.by.dao.exception.DAOException;
import informationhandlinglight.training.by.service.exception.ServiceException;

public class ReadCommand {
    public String exec() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        TextDAO textDAO = daoFactory.getTextDao();
        try {
            return textDAO.readText();
        } catch (DAOException e) {
            throw new ServiceException("Unable to read data", e.getCause());
        }
    }
}
