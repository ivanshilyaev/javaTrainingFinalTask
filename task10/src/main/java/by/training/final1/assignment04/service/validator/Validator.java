package by.training.final1.assignment04.service.validator;

import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.service.exception.ServiceException;

public class Validator {
    public void validateTreasure(Treasure treasure) throws ServiceException {
        if (treasure.getPrice() <= 0) {
            throw new ServiceException("Validation error: illegal price");
        }
    }

    public void validateCommand(String item) throws ServiceException {
        String[] array = item.split(" ");
        if (array.length == 2) {
            int price;
            try {
                price = Integer.parseInt(array[1]);
            } catch (NumberFormatException e) {
                throw new ServiceException("Incorrect command", e.getCause());
            }
            if (price <= 0) {
                throw new ServiceException("Incorrect command");
            }
        }
    }
}
