package by.training.linearalgorithms.linearalgorithms10.controller;

import by.training.linearalgorithms.linearalgorithms10.service.CountCommand;
import by.training.linearalgorithms.linearalgorithms10.service.Reader;
import by.training.linearalgorithms.linearalgorithms10.service.Writer;

public class Runner {
    public static String directory = "/Users/ivansilaev/Desktop/javaTraining/task01/src/main/java/by/training/linearalgorithms/linearalgorithms10/resources";

    public static void main(String[] args) {
        double[] data = new double[2];
        if (!new Reader().read(data)) {
            System.out.println("Incorrect data");
            System.exit(0);
        }
        try {
            if (!new Writer().write(new CountCommand().exec(data[0], data[1])))
                System.out.println("Couldn't write to file");
            else
                System.out.println("Result has been written successfully");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
