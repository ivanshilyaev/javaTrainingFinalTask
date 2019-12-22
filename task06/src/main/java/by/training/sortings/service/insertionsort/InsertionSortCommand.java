package by.training.sortings.service.insertionsort;

public class InsertionSortCommand {
    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    // сортировка простыми вставками
    public void execAlgorithm(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = tmp;
        }
    }

    // сортировка простыми вставками с бинарным поиском
    public void execModifiedAlgorithm(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int tmp = array[i];
            int left = -1;
            int right = i;
            while (left < right - 1) {
                int center = (right + left) / 2;
                // searching for position to insert next element
                if (array[center] < tmp) {
                    left = center;
                } else {
                    right = center;
                }
            }
            // shifting all the elements, freeing space for a new element
            for (int j = i; j > right; --j) {
                array[j] = array[j - 1];
            }
            array[right] = tmp;
        }
    }

    // сортировка Шелла
    public void shellSort(int[] array) {
        for (int step = array.length / 2; step > 0; step /= 2) {
            for (int i = step; i < array.length; i++) {
                for (int j = i - step; j >= 0 && array[j] > array[j + step]; j -= step) {
                    int tmp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = tmp;
                }
            }
        }
    }
}
