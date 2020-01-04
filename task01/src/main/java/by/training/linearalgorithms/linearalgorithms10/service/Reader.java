package by.training.linearalgorithms.linearalgorithms10.service;

import by.training.linearalgorithms.linearalgorithms10.dao.FileReader;

public class Reader {
    public boolean read(double[] array) {
        return new FileReader().read(array);
    }
}
