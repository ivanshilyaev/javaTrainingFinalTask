package by.training.arrays1.assignment15.service;

public class ParseData {
    public double[] parse(String data, int size) {
        double[] array = new double[size];
        String[] tmp = data.split(" ");
        for (int i = 0; i < size; ++i) {
            array[i] = Double.parseDouble(tmp[i]);
        }
        return array;
    }
}
