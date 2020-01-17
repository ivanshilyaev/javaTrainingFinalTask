package by.training.final1.assignment04.service.validator;

import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.service.exception.ServiceException;

public class Validator {
    public void validate(Treasure treasure) throws ServiceException {
        if (treasure.getPrice() <= 0) {
            throw new ServiceException("Validation error: illegal price");
        }
    }
}
