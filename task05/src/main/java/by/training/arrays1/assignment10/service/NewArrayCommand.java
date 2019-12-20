package by.training.arrays1.assignment10.service;

import by.training.arrays1.assignment05.service.exception.ZeroSizeException;

public class NewArrayCommand {
    public int[] exec(int[] array) throws ZeroSizeException {
        int size = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > i) {
                ++size;
            }
        }
        if (size == 0) {
            throw new ZeroSizeException("No such numbers");
        }
        int[] result = new int[size];
        int j = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > i) {
                result[j] = array[i];
                ++j;
            }
        }
        return result;
    }
}
