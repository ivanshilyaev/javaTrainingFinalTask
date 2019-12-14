package by.training.linearalgorithms.linearalgorithms31.controller;

import java.io.*;

public class Runner {
    private static String directory = "/Users/ivansilaev/Desktop/javaTraining/task01/src/main/java/by/training/linearalgorithms/linearalgorithms31/resources";
    private static String inputFilename = "input.txt";
    private static String outputFilename = "output.txt";
    private static String absoluteInputFilename = directory + File.separator + inputFilename;
    private static String absoluteOutputFilename = directory + File.separator + outputFilename;

    public static boolean readFromFile(double[] array) {
        try (BufferedReader reader = new BufferedReader(new FileReader(absoluteInputFilename))) {
            for (int i = 0; i < 4; ++i) {
                String line = reader.readLine();
                if (line == null)
                    return false;
                array[i] = Double.parseDouble(line);
            }
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

    public static double countDistance(double v, double v1, double t1, double t2) {
        return v * t1 + (v - v1) * t2;
    }

    public static void main(String[] args) {
        double[] data = new double[4]; // {v, v1, t1, t2}
        if (!readFromFile(data)) {
            System.out.println("Incorrect data");
            System.exit(0);
        }
        if (!writeToFile(countDistance(data[0], data[1], data[2], data[3])))
            System.out.println("Couldn't write to file");
        else
            System.out.println("Result has been written successfully");
    }
}
