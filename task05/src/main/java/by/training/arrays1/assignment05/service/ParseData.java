package by.training.arrays1.assignment05.service;

public class ParseData {
    public int[] parse(String data, int size) {
        int[] array = new int[size];
        String[] tmp = data.split(" ");
        for (int i = 0; i < size; ++i) {
            array[i] = Integer.parseInt(tmp[i]);
        }
        return array;
    }
}
