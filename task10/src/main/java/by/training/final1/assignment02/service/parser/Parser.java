package by.training.final1.assignment02.service.parser;

import by.training.final1.assignment02.bean.Commodity;
import by.training.final1.assignment02.service.exception.ServiceException;

public class Parser {
    public Commodity parseString(String data) throws ServiceException {
        String[] array = data.split(" ");
        double price;
        try {
            price = Double.parseDouble(array[2]);
        } catch (NumberFormatException e) {
            throw new ServiceException("Parsing error", e.getCause());
        }
        return new Commodity(array[0], array[1], price);
    }
}
