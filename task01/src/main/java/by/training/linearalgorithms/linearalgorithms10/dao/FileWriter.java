package by.training.linearalgorithms.linearalgorithms10.dao;

import by.training.linearalgorithms.linearalgorithms10.controller.Runner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriter {
    private static String outputFilename = "output.txt";
    private static String absoluteOutputFilename = Runner.directory + File.separator + outputFilename;

    public boolean write(double result) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(absoluteOutputFilename))) {
            writer.write(String.valueOf(result));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
