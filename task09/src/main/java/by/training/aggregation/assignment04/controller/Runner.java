package by.training.aggregation.assignment04.controller;

import by.training.aggregation.assignment04.bean.Bank;
import by.training.aggregation.assignment04.bean.Currency;
import by.training.aggregation.assignment04.controller.command.Command;
import by.training.aggregation.assignment04.controller.command.exception.CommandException;

public class Runner {
    private final CommandProvider provider = new CommandProvider();

    public double getAmount(String request, Bank bank, String name, Currency currency)
            throws CommandException {
        Command executionCommand = provider.getCommand(request);
        return executionCommand.execute(bank, name, currency);
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        
    }
}
