package by.training.methods.methods05.view;

import java.util.Scanner;

public class ReadData {
    public String read(int n) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            System.out.print("Double a" + (i + 1) + ": ");
            res.append(scanner.nextLine()).append(" ");
        }
        return res.toString();
    }
}
