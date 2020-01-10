package by.training.aggregation.assignment04.view;

import by.training.aggregation.assignment04.bean.Currency;

import java.util.Scanner;

public final class ConsoleHelper {
    private static final ConsoleHelper INSTANCE = new ConsoleHelper();

    private ConsoleHelper() {
    }

    public static ConsoleHelper getInstance() {
        return INSTANCE;
    }

    private Scanner scanner = new Scanner(System.in);

    public String readString() {
        return scanner.nextLine();
    }

    public void writeMessage(String message) {
        System.out.println(message);
    }

    public String readName() {
        System.out.println("Enter name");
        return readString();
    }

    public Currency readCurrency() {
        System.out.println("Enter currency (USD, EUR or BLR):");
        String choice = scanner.nextLine();
        Currency currency;
        try {
            currency = Currency.valueOf(choice.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("No such currency. Try again");
            currency = readCurrency();
        }
        return currency;
    }

    public double readSum() {
        System.out.println("Enter sum (positive double):");
        double sum;
        try {
            sum = Double.parseDouble(readString());
            if (sum < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Error. Try again:");
            sum = readSum();
        }
        return sum;
    }
}
