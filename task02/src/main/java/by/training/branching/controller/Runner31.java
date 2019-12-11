package by.training.branching.controller;

import java.util.Scanner;

public class Runner31 {
    public static void check(double a, double b, double x, double y, double z) {
        if ((x <= a && y <= b) || (y <= a && x <= b) || (x <= a && z <= b) ||
                (z <= a && x <= b) || (y <= a && z <= b) || (z <= a && y <= b))
            System.out.println("Success!");
        else
            System.out.println("Failure");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double z = scanner.nextDouble();
        check(a, b, x, y, z);
    }
}
