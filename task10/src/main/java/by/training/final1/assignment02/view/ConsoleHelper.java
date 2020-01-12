package by.training.final1.assignment02.view;

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

    public int readInt() {
        int result;
        try {
            result = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            printMessage("Wrong data. Try again:");
            result = readInt();
        }
        return result;
    }

    public double readDouble() {
        double result;
        try {
            result = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            printMessage("Wrong data. Try again:");
            result = readDouble();
        }
        return result;
    }

    public String readName() {
        System.out.print("Name: ");
        return readString();
    }

    public double readPrice() {
        System.out.print("Price: ");
        return readDouble();
    }

    public double readDiscount() {
        System.out.print("Discount: ");
        return readDouble();
    }

    public int readQuantity() {
        System.out.print("Quantity: ");
        return readInt();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
