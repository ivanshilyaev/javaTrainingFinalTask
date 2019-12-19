package by.training.methods.methods20.service;

public class CountCommand {
    public int exec(int n) {
        return numberOfIterations(n);
    }

    private int numberOfIterations(int n) {
        int count = 0;
        while (n > 0) {
            n = numberMinusSumOfDigits(n);
            ++count;
        }
        return count;
    }

    private int numberMinusSumOfDigits(int n) {
        int sum = 0;
        int tmp = n;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return n - sum;
    }
}
