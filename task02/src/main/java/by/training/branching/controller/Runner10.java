package by.training.branching.controller;

import java.util.Arrays;

public class Runner10 {
    public static void main(String[] args) {
        Circle[] array = new Circle[5];
        for (int i=1; i<=5; ++i) {
            array[i-1] = new Circle(i, i, Math.random() * i);
        }
        System.out.println("Original circles:");
        for (Circle circle : array)
            System.out.println(circle);
        Arrays.sort(array);
        System.out.println("Smallest circle: " + array[0]);
    }
}
