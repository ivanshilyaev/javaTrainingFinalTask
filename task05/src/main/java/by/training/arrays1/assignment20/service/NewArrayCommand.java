package by.training.arrays1.assignment20.service;

public class NewArrayCommand {
    public int[] exec(int[] array) {
        int[] result = array.clone();
        for (int i = 1; i < (result.length + 1) / 2; ++i) {
            result[i] = result[2 * i];
        }
        for (int i = (result.length + 1) / 2; i < result.length; ++i) {
            result[i] = 0;
        }
        return result;
    }
}
