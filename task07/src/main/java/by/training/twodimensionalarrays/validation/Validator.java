package by.training.twodimensionalarrays.validation;

public class Validator {
    public boolean checkIndex(int index, int matrixSize) {
        return index >= 0 && index < matrixSize;
    }
}
