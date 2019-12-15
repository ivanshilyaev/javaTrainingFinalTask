package by.training.branching.branchingamount.controller;

import by.training.branching.branchingamount.service.AmountCommand;
import by.training.branching.branchingamount.view.ReadData;

import java.util.InputMismatchException;

public class Runner {
    public static void main(String[] args) {
        try {
            String data = new ReadData().read();
            System.out.println(new AmountCommand().exec(data));
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
