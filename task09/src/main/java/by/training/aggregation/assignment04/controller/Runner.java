package by.training.aggregation.assignment04.controller;

import by.training.aggregation.assignment04.bean.Bank;
import by.training.aggregation.assignment04.bean.BankAccount;
import by.training.aggregation.assignment04.bean.Currency;
import by.training.aggregation.assignment04.controller.command.Command;
import by.training.aggregation.assignment04.controller.command.exception.CommandException;
import by.training.aggregation.assignment04.view.ConsoleHelper;

public class Runner {
    private final CommandProvider provider = new CommandProvider();

    public double getAmount(String request, Bank bank, String name, Currency currency)
            throws CommandException {
        Command executionCommand = provider.getCommand(request);
        return executionCommand.execute(bank, name, currency);
    }

    public Bank getTestData() {
        Bank bank = new Bank("National Bank");
        BankAccount account1 = new BankAccount("Ivan", Currency.USD, 300);
        BankAccount account2 = new BankAccount("Pavel", Currency.EUR, 500);
        BankAccount account3 = new BankAccount("Ilya", Currency.BLR, 600);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        return bank;
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
        Bank bank = runner.getTestData();
    }
}
