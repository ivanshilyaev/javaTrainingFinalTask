package by.training.methods.methods05.controller;

import by.training.methods.methods05.service.CountCommand;
import by.training.methods.methods05.service.ParseData;
import by.training.methods.methods05.view.ReadData;

public class Runner {
    private static final int SIZE = 3;

    public static void main(String[] args) {
        try {
            String data = new ReadData().read(SIZE);
            double[] array = new ParseData().parse(data, SIZE);
            CountCommand command = new CountCommand();
            System.out.println(command.sumOfMinAndMax(array));
        } catch (NumberFormatException e) {
            System.out.println("Incorrect data");
        }
    }
}
