package by.training.demothreads.matrixelement.service;

import by.training.demothreads.matrix.bean.exception.MatrixException;
import by.training.demothreads.matrixelement.bean.ElementMatrix;

import java.util.Random;

public class ThreadDiagonalFiller extends Thread {
    private ElementMatrix matrix;
    private int value;

    public ThreadDiagonalFiller(ElementMatrix matrix, int value) {
        this.matrix = matrix;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            for (int j = 0; j < matrix.getVerticalSize(); ++j) {
                int i = random.nextInt(matrix.getVerticalSize() - 1);
                if (matrix.getElement(i, i).getNumberOfChanges() == 0) {
                    matrix.setElement(i, i, value);
                }
            }
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }
}
