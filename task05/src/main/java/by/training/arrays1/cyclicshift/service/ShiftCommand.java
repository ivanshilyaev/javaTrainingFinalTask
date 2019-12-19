package by.training.arrays1.cyclicshift.service;

public class ShiftCommand {
    public void exec(int[] array, int n, boolean right) {
        if (right) {
            cyclicNTimesRightShift(array, n);
        } else {
            cyclicNTimesLeftShift(array, n);
        }
    }

    private void cyclicRightShift(int[] array) {
        int tmp = array[array.length - 1];
        for (int i = array.length - 1; i > 0; --i) {
            array[i] = array[i - 1];
        }
        array[0] = tmp;
    }

    private void cyclicLeftShift(int[] array) {
        int tmp = array[0];
        for (int i = 0; i < array.length - 2; ++i) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = tmp;
    }

    private void cyclicNTimesRightShift(int[] array, int n) {
        for (int i = 0; i < n; ++i) {
            cyclicRightShift(array);
        }
    }

    private void cyclicNTimesLeftShift(int[] array, int n) {
        for (int i = 0; i < n; ++i) {
            cyclicLeftShift(array);
        }
    }
}
