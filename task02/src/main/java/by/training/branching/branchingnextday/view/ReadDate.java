package by.training.branching.branchingnextday.view;

import java.util.Scanner;

public class ReadDate {
    public String read() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        System.out.print("Day: ");
        result.append(scanner.nextLine()).append(" ");
        System.out.print("Month: ");
        result.append(scanner.nextLine()).append(" ");
        System.out.print("Year: ");
        result.append(scanner.nextLine()).append(" ");
        return result.toString();
    }
}
