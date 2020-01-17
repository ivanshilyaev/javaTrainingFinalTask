package by.training.final1.assignment01.view;

import java.util.Scanner;

public class ConsoleHelper {
    private Scanner scanner = new Scanner(System.in);

    public boolean hasNext() {
        return scanner.hasNext();
    }

    public String readString() {
        return scanner.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
