package by.training.cycles.cycles10.service;

public class CountCommand {
    private int factorialOfSquares(int n, int[] result) {
        result[0] = 1;
        int size = 1;
        for (int i = 2; i <= n; ++i) {
            size = multiply((int) Math.pow(i, 2), result, size);
        }
        return size;
    }

    private int multiply(int x, int[] result, int size) {
        int carry = 0;
        for (int i = 0; i < size; ++i) {
            int prod = x * result[i] + carry;
            result[i] = prod % 10;
            carry = prod / 10;
        }
        while (carry != 0) {
            result[size] = carry % 10;
            carry /= 10;
            ++size;
        }
        return size;
    }

    public int exec(int[] result) {
        return factorialOfSquares(200, result);
    }
}
