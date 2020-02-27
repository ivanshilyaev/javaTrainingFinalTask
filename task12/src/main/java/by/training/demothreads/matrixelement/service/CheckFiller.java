package by.training.demothreads.matrixelement.service;

import by.training.demothreads.matrix.bean.exception.MatrixException;
import by.training.demothreads.matrixelement.bean.ElementMatrix;

public class CheckFiller extends Thread {
    private ElementMatrix matrix;
    private int value;

    public CheckFiller(ElementMatrix matrix, int value) {
        this.matrix = matrix;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < matrix.getVerticalSize(); ++i) {
                if (matrix.getElement(i, i).getNumberOfChanges() == 0) {
                    matrix.setElement(i, i, value);
                }
            }
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }
}
