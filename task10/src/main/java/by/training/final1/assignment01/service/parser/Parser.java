package by.training.final1.assignment01.service.parser;

import by.training.final1.assignment01.service.exception.ServiceException;

public class Parser {
    public void parseFileName(String name) throws ServiceException {
        String[] array = name.split("\\.");
        if (array.length < 2) {
            throw new ServiceException("Invalid file name");
        }
    }
}
