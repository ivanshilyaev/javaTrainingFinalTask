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

    public void writeSum(double sum) {
        System.out.println(sum);
    }

    public String readName() {
        System.out.println("Enter name");
        return readString();
    }

    public void showMenu() {
        System.out.println("1 - get account");
        System.out.println("2 - sort accounts");
        System.out.println("3 - get total client amount");
        System.out.println("4 - get total positive client amount");
        System.out.println("5 - get total negative client amount");
        System.out.println("6 - put money");
        System.out.println("7 - withdraw money");
        System.out.println("8 - block accounts");
        System.out.println("9 - show all accounts");
        System.out.println("e - exit");
    }

    public String runDialog() {
        System.out.println("\n" + "Enter command:");
        return scanner.nextLine();
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
