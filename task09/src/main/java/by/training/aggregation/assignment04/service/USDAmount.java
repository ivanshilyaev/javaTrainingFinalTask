package by.training.aggregation.assignment04.service;

import by.training.aggregation.assignment04.bean.Bank;
import by.training.aggregation.assignment04.bean.BankAccount;
import by.training.aggregation.assignment04.bean.Currency;

public class USDAmount {
    public double exchangeSumToUSD(BankAccount account) {
        switch (account.getCurrency()) {
            case USD:
                return account.getSum();
            case EUR:
                return Currency.EUR_TO_USD * account.getSum();
            case BLR:
                return Currency.BLR_TO_USD * account.getSum();
            default:
                return 0;
        }
    }

    public double getTotalPositiveUSDAmount(Bank bank, String name) {
        double result = 0;
        for (BankAccount account : bank.getAccounts()) {
            if (account.getName().equalsIgnoreCase(name) && account.getSum() > 0) {
                result += exchangeSumToUSD(account);
            }
        }
        return result;
    }

    public double getTotalNegativeUSDAmount(Bank bank, String name) {
        double result = 0;
        for (BankAccount account : bank.getAccounts()) {
            if (account.getName().equalsIgnoreCase(name) && account.getSum() < 0) {
                result += exchangeSumToUSD(account);
            }
        }
        return result;
    }

    public double getTotalUSDAmount(Bank bank, String name) {
        return getTotalPositiveUSDAmount(bank, name) +
                getTotalNegativeUSDAmount(bank, name);
    }
}
