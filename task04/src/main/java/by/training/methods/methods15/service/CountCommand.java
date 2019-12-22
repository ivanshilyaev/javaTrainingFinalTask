package by.training.methods.methods15.service;

import by.training.methods.methods15.service.exception.NoSuchNumbersException;

import java.util.ArrayList;

public class CountCommand {
    public int[] exec(int k, int n) throws NoSuchNumbersException {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (sumOfDigits(i) == k) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            throw new NoSuchNumbersException("Sum can't be " + k);
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            array[i] = result.get(i);
        }
        return array;
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}
