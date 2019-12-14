package by.training.linearalgorithms.linearalgorithms10.dao;

import by.training.linearalgorithms.linearalgorithms10.controller.Runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    private static String inputFilename = "input.txt";
    private static String absoluteInputFilename = Runner.directory + File.separator + inputFilename;

    public boolean read(double[] array) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(absoluteInputFilename))) {
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
}
