package by.training.linearalgorithms.linearalgorithms10.service;

import by.training.linearalgorithms.linearalgorithms10.dao.FileWriter;

public class Writer {
    public boolean write(double result) {
        return new FileWriter().write(result);
    }
}
