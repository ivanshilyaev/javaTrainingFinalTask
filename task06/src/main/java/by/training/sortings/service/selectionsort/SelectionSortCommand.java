package by.training.sortings.service.selectionsort;

public class SelectionSortCommand {
    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public void execAlgorithm(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int index = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {
                swap(array, i, index);
            }
        }
    }

    // двухсторонняя сортировка выбором
    public void execModifiedAlgorithm(int[] array) {
        int size = array.length;
        int halfSize = size / 2;
        for (int i = 0; i < halfSize; ++i) {
            int indexMin = i;
            int indexMax = i;
            for (int j = i + 1; j < size - i; ++j) {
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
                if (array[j] > array[indexMax]) {
                    indexMax = j;
                }
            }
            // проверки!!!
            if (i != indexMin) {
                swap(array, i, indexMin);
            }
            if (size - i - 1 != indexMax) {
                if (i != indexMax) {
                    swap(array, size - i - 1, indexMax);
                } else {
                    swap(array, size - i - 1, indexMin);
                }
            }
        }
    }
}
