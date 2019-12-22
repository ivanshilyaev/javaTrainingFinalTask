package by.training.sortings.service.oddevensort;

public class OddEvenSortCommand {
    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    // ещё одно улучшение пузырьковой сортировки
    public void exec(int[] array) {
        int numOfChanges;
        do {
            numOfChanges = 0;
            for (int i = 0; i < array.length - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    ++numOfChanges;
                }
            }
            for (int i = 1; i < array.length - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    ++numOfChanges;
                }
            }
        } while (numOfChanges > 0);
    }
}
