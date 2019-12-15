package by.training.cycles.cycles21.view;

import java.util.Scanner;

public class ReadData {
    public String read() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        System.out.print("Double a: ");
        res.append(scanner.nextLine()).append(" ");
        System.out.print("Double b: ");
        res.append(scanner.nextLine()).append(" ");
        System.out.print("Double h: ");
        res.append(scanner.nextLine()).append(" ");
        return res.toString();
    }
}
