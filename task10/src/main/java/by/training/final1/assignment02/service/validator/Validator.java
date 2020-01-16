package by.training.final1.assignment02.service.validator;

import by.training.final1.assignment02.bean.Commodity;
import by.training.final1.assignment02.service.exception.ServiceException;

public class Validator {
    public void validate(Commodity commodity) throws ServiceException {
        if (!commodity.getBarcode().matches("[A-Z]{3}-[a-z]{3}-[0-9]{4}")) {
            throw new ServiceException("Validation error: illegal barcode");
        }
        if (commodity.getPrice() <= 0) {
            throw new ServiceException("Validation error: illegal price");
        }
    }
}
