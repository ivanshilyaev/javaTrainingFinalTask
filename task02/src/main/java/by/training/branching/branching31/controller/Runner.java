package by.training.branching.branching31.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void check(double a, double b, double x, double y, double z) {
        if ((x <= a && y <= b) || (y <= a && x <= b) || (x <= a && z <= b) ||
                (z <= a && x <= b) || (y <= a && z <= b) || (z <= a && y <= b))
            System.out.println("Success!");
        else
            System.out.println("Failure");
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Double a: ");
            double a = scanner.nextDouble();
            System.out.print("Double b: ");
            double b = scanner.nextDouble();
            System.out.print("Double x: ");
            double x = scanner.nextDouble();
            System.out.print("Double y: ");
            double y = scanner.nextDouble();
            System.out.print("Double z: ");
            double z = scanner.nextDouble();
            check(a, b, x, y, z);
            if (a <= 0 || b <= 0 || x <= 0 || y <= 0 || z <= 0)
                throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect data");
        }
    }
}
