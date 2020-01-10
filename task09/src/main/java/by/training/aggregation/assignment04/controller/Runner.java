package by.training.aggregation.assignment04.controller;

import by.training.aggregation.assignment04.bean.Bank;
import by.training.aggregation.assignment04.bean.BankAccount;
import by.training.aggregation.assignment04.bean.Currency;
import by.training.aggregation.assignment04.controller.command.Command;
import by.training.aggregation.assignment04.controller.command.exception.CommandException;
import by.training.aggregation.assignment04.service.BankService;
import by.training.aggregation.assignment04.service.exception.ServiceException;
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
        BankService bankService = BankService.getInstance();
        Bank bank = runner.getTestData();
        consoleHelper.showMenu();
        try {
            while (true) {
                String choice = consoleHelper.runDialog();
                switch (choice) {
                    case "1": {
                        String name = consoleHelper.readName();
                        Currency currency = consoleHelper.readCurrency();
                        consoleHelper.writeMessage(bankService.getAccount(bank, name, currency).toString());
                        break;
                    }
                    case "2": {
                        bankService.sortAccounts(bank);
                        break;
                    }
                    case "3": {
                        String name = consoleHelper.readName();
                        Currency currency = consoleHelper.readCurrency();
                        // shouldn't be used this way ¯\_(ツ)_/¯
                        consoleHelper.writeSum(runner.getAmount("GET_TOTAL_AMOUNT", bank, name, currency));
                        break;
                    }
                    case "4": {
                        String name = consoleHelper.readName();
                        Currency currency = consoleHelper.readCurrency();
                        // shouldn't be used this way ¯\_(ツ)_/¯
                        consoleHelper.writeSum(runner.getAmount("GET_TOTAL_POSITIVE_AMOUNT", bank, name, currency));
                        break;
                    }
                    case "5": {
                        String name = consoleHelper.readName();
                        Currency currency = consoleHelper.readCurrency();
                        // shouldn't be used this way ¯\_(ツ)_/¯
                        consoleHelper.writeSum(runner.getAmount("GET_TOTAL_NEGATIVE_AMOUNT", bank, name, currency));
                        break;
                    }
                    case "6": {
                        String name = consoleHelper.readName();
                        Currency currency = consoleHelper.readCurrency();
                        double addSum = consoleHelper.readSum();
                        bankService.putMoney(bank, name, currency, addSum);
                        break;
                    }
                    case "7": {
                        String name = consoleHelper.readName();
                        Currency currency = consoleHelper.readCurrency();
                        double addSum = consoleHelper.readSum();
                        bankService.withdrawMoney(bank, name, currency, addSum);
                        break;
                    }
                    case "8": {
                        bankService.blockAccounts(bank);
                        break;
                    }
                    case "9": {
                        consoleHelper.writeMessage(bank.getName() + ":");
                        for (BankAccount account : bank.getAccounts()) {
                            consoleHelper.writeMessage(account.toString());
                        }
                        break;
                    }
                    case "e": {
                        return;
                    }
                    default: {
                        break;
                    }
                }
            }
        } catch (ServiceException | CommandException e) {
            consoleHelper.writeMessage("Error while processing command");
        }
    }
}
