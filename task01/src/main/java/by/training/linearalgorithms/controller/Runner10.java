package by.training.linearalgorithms.controller;

import java.io.*;

import static java.lang.Math.*;

public class Runner10 {
    private static String directory = System.getProperty("user.home");
    private static String inputFilename = "input.txt";
    private static String outputFilename = "output.txt";
    private static String absoluteInputFilename = directory + File.separator + inputFilename;
    private static String absoluteOutputFilename = directory + File.separator + outputFilename;

    public static double countValue(double x, double y) {
        double denominator = cos(x) - sin(y);
        if ((cos(x * y) == 0) || (denominator == 0))
            throw new IllegalArgumentException("Division by zero");
        return tan(x * y) * (sin(x) + cos(y)) / (denominator);
    }

    public static boolean readFromFile(double[] array) {
        try (BufferedReader reader = new BufferedReader(new FileReader(absoluteInputFilename))) {
            array[0] = Double.parseDouble(reader.readLine());
            array[1] = Double.parseDouble(reader.readLine());
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean writeToFile(double result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(absoluteOutputFilename))) {
            writer.write(String.valueOf(result));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        double[] data = new double[2];
        if (!readFromFile(data)) {
            System.out.println("Incorrect data");
            System.exit(0);
        }
        try {
            if (!writeToFile(countValue(data[0], data[1])))
                System.out.println("Couldn't write to file");
            else
                System.out.println("Result has been written successfully");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
