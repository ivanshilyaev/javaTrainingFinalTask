package by.training.methods.methods20.controller;

import by.training.methods.methods20.service.CountCommand;
import by.training.methods.methods20.view.ReadData;

import java.util.InputMismatchException;

public class Runner {
    public static void main(String[] args) {
        try {
            ReadData readData = new ReadData();
            int n = readData.readInt();
            System.out.println("Number of iterations: (num - sum of digits)");
            System.out.println(new CountCommand().exec(n));
        } catch (InputMismatchException e) {
            System.out.println("Incorrect data");
        }
    }
}
