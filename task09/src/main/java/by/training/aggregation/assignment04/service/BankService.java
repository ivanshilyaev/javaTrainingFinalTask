package by.training.aggregation.assignment04.service;

import by.training.aggregation.assignment04.bean.Bank;
import by.training.aggregation.assignment04.bean.BankAccount;
import by.training.aggregation.assignment04.bean.Currency;
import by.training.aggregation.assignment04.service.exception.ServiceException;

public class BankService {
    public BankAccount getAccount(Bank bank, String name, Currency currency)
            throws ServiceException {
        for (BankAccount account : bank.getAccounts()) {
            if (account.getName().equalsIgnoreCase(name) && account.getCurrency() == currency) {
                return account;
            }
        }
        throw new ServiceException("No such account");
    }
}
