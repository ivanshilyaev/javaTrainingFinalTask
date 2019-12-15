package by.training.branching.branching20.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
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
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Integer a: ");
            int a = scanner.nextInt();
            System.out.print("Integer b: ");
            int b = scanner.nextInt();
            System.out.print("Integer c: ");
            int c = scanner.nextInt();
            System.out.print("Integer k: ");
            int k = scanner.nextInt();
            findDividends(a, b, c, k);
        } catch (InputMismatchException e) {
            System.out.println("Incorrect data");
        }
    }
}
