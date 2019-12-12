package by.training.branching.brangingseasons.view;

import java.util.Scanner;

public class ReadData {
    public String read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month number: ");
        return scanner.nextLine();
    }
}
