package by.training.sortings.service.combsort;

public class CombSortCommand {
    private static final double FACTOR = 1.247;

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    // последнее улучшение пузырьковой сортировки
    public void exec(int[] array) {
        int step = (int) Math.round(array.length / FACTOR);
        while (step > 1) {
            for (int j = 0; j < array.length - step - 1; ++j) {
                if (array[j] > array[j + step]) {
                    swap(array, j, j + step);
                }
            }
            step = (int) (step / FACTOR);
        }
        boolean swapped;
        for (int i = 0; i < array.length - 1; ++i) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
