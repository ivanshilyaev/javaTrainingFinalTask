package by.training.branching.controller;

import java.util.Scanner;

public class Runner20 {
    public static void findDividends(int a, int b, int c, int k) {
        System.out.println("Dividends:");
        if (a % k == 0)
            System.out.println(a);
        else if (b % k == 0)
            System.out.println(b);
        else if (c % k == 0)
            System.out.println(c);
        else
            System.out.println("No dividends");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int k = scanner.nextInt();
        findDividends(a, b, c, k);
    }
}
