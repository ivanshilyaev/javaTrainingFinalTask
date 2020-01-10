package by.training.aggregation.assignment04.controller.command;

import by.training.aggregation.assignment04.bean.Bank;
import by.training.aggregation.assignment04.bean.Currency;

public interface Command {
    double execute(Bank bank, String name, Currency currency);
}
