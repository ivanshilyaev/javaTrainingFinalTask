package by.training.sortings.service.shakersort;

public class ShakerSortCommand {
    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    // улучшение пузырьковой сортировки
    public void exec(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int k = 0; // индека последнего обмена
        while (left < right) {
            for (int j = left; j < right; ++j) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    k = j;
                }
            }
            right = k;
            for (int j = right - 1; j >= left; --j) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    k = j;
                }
            }
            left = k;
        }
    }
}
