package by.training.branching.branchingamount.view;

import java.util.Scanner;

public class ReadData {
    public String read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount (<10000): ");
        return scanner.nextLine();
    }
}
