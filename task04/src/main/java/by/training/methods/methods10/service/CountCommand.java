package by.training.methods.methods10.service;

public class CountCommand {
    public int exec(int n) {
        return sumOfOddFactorials(n);
    }

    private int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    private int sumOfOddFactorials(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += factorial(i);
        }
        return sum;
    }
}
