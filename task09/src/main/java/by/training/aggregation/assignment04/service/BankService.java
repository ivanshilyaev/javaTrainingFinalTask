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

    public void sortAccounts(Bank bank) {
        bank.sortAccounts();
    }

    public double getTotalAmount(Bank bank, String name, Currency currency) {
        AmountFactory factory = AmountFactory.getInstance();
        switch (currency) {
            case USD:
                USDAmount usdAmount = factory.getUsdAmount();
                return usdAmount.getTotalUSDAmount(bank, name);
            case EUR:
                EURAmount eurAmount = factory.getEurAmount();
                return eurAmount.getTotalEURAmount(bank, name);
            case BLR:
                BLRAmount blrAmount = factory.getBlrAmount();
                return blrAmount.getTotalBLRAmount(bank, name);
            default:
                return 0;
        }
    }

    public double getTotalPositiveAmount(Bank bank, String name, Currency currency) {
        AmountFactory factory = AmountFactory.getInstance();
        switch (currency) {
            case USD:
                USDAmount usdAmount = factory.getUsdAmount();
                return usdAmount.getTotalPositiveUSDAmount(bank, name);
            case EUR:
                EURAmount eurAmount = factory.getEurAmount();
                return eurAmount.getTotalPositiveEURAmount(bank, name);
            case BLR:
                BLRAmount blrAmount = factory.getBlrAmount();
                return blrAmount.getTotalPositiveBLRAmount(bank, name);
            default:
                return 0;
        }
    }

    public double getTotalNegativeAmount(Bank bank, String name, Currency currency) {
        AmountFactory factory = AmountFactory.getInstance();
        switch (currency) {
            case USD:
                USDAmount usdAmount = factory.getUsdAmount();
                return usdAmount.getTotalNegativeUSDAmount(bank, name);
            case EUR:
                EURAmount eurAmount = factory.getEurAmount();
                return eurAmount.getTotalNegativeEURAmount(bank, name);
            case BLR:
                BLRAmount blrAmount = factory.getBlrAmount();
                return blrAmount.getTotalNegativeBLRAmount(bank, name);
            default:
                return 0;
        }
    }
}
