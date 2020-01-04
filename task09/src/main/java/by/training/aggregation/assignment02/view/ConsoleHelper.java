package by.training.aggregation.assignment02.view;

import java.util.Scanner;

public class ConsoleHelper {
    private Scanner scanner = new Scanner(System.in);

    public boolean hasNext() {
        return scanner.hasNext();
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void writeLine(String line) {
        System.out.println(line);
    }
}
