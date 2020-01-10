package by.training.aggregation.assignment04.service;

import by.training.aggregation.assignment04.bean.Bank;
import by.training.aggregation.assignment04.bean.BankAccount;
import by.training.aggregation.assignment04.bean.Currency;

public class EURAmount {
    public double exchangeSumToEUR(BankAccount account) {
        switch (account.getCurrency()) {
            case EUR:
                return account.getSum();
            case USD:
                return Currency.USD_TO_EUR * account.getSum();
            case BLR:
                return Currency.BLR_TO_EUR * account.getSum();
            default:
                return 0;
        }
    }

    public double getTotalPositiveEURAmount(Bank bank, String name) {
        double result = 0;
        for (BankAccount account : bank.getAccounts()) {
            if (account.getName().equalsIgnoreCase(name) && account.getSum() > 0) {
                result += exchangeSumToEUR(account);
            }
        }
        return result;
    }

    public double getTotalNegativeEURAmount(Bank bank, String name) {
        double result = 0;
        for (BankAccount account : bank.getAccounts()) {
            if (account.getName().equalsIgnoreCase(name) && account.getSum() < 0) {
                result += exchangeSumToEUR(account);
            }
        }
        return result;
    }

    public double getTotalEURAmount(Bank bank, String name) {
        return getTotalPositiveEURAmount(bank, name) +
                getTotalNegativeEURAmount(bank, name);
    }
}
