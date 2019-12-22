package by.training.methods.methods15.view;

import java.util.Scanner;

public class ReadData {
    public int[] read() {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        return new int[]{k, n};
    }
}
