package by.training.arrays1.assignment15.view;

import java.util.Scanner;

public class ReadData {
    private static Scanner scanner = new Scanner(System.in);

    public String readArray(int n) {
        System.out.println("Enter array of " + n + " double numbers");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            System.out.print("Double a" + (i + 1) + ": ");
            res.append(scanner.nextLine()).append(" ");
        }
        return res.toString();
    }

    public double readDouble() {
        System.out.println("Enter double:");
        return scanner.nextDouble();
    }
}
