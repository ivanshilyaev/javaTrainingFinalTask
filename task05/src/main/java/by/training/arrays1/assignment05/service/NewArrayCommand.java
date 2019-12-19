package by.training.arrays1.assignment05.service;

import by.training.arrays1.assignment05.service.exception.ZeroSizeException;

public class NewArrayCommand {
    public int[] exec(int[] array) throws ZeroSizeException {
        int size = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                ++size;
            }
        }
        if (size == 0) {
            throw new ZeroSizeException("No even numbers");
        }
        int[] result = new int[size];
        int j = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                result[j] = value;
                ++j;
            }
        }
        return result;
    }
}
