package by.training.aggregation.assignment04.service;

import by.training.aggregation.assignment04.bean.Bank;
import by.training.aggregation.assignment04.bean.BankAccount;
import by.training.aggregation.assignment04.bean.Currency;

public class BLRAmount {
    public double exchangeSumToBLR(BankAccount account) {
        switch (account.getCurrency()) {
            case BLR:
                return account.getSum();
            case USD:
                return Currency.USD_TO_BLR * account.getSum();
            case EUR:
                return Currency.EUR_TO_BLR * account.getSum();
            default:
                return 0;
        }
    }

    public double getTotalPositiveBLRAmount(Bank bank, String name) {
        double result = 0;
        for (BankAccount account : bank.getAccounts()) {
            if (account.getName().equalsIgnoreCase(name) && account.getSum() > 0) {
                result += exchangeSumToBLR(account);
            }
        }
        return result;
    }

    public double getTotalNegativeBLRAmount(Bank bank, String name) {
        double result = 0;
        for (BankAccount account : bank.getAccounts()) {
            if (account.getName().equalsIgnoreCase(name) && account.getSum() < 0) {
                result += exchangeSumToBLR(account);
            }
        }
        return result;
    }

    public double getTotalBLRAmount(Bank bank, String name) {
        return getTotalPositiveBLRAmount(bank, name) +
                getTotalNegativeBLRAmount(bank, name);
    }
}
