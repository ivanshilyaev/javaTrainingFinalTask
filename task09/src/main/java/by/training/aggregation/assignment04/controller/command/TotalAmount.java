package by.training.aggregation.assignment04.controller.command;

import by.training.aggregation.assignment04.bean.Bank;
import by.training.aggregation.assignment04.bean.Currency;
import by.training.aggregation.assignment04.service.BankService;

public class TotalAmount implements Command {
    @Override
    public double execute(Bank bank, String name, Currency currency) {
        BankService service = BankService.getInstance();
        return service.getTotalAmount(bank, name, currency);
    }
}
