package by.training.demoThreads.matrix.service;

import by.training.demoThreads.matrix.bean.Matrix;
import by.training.demoThreads.matrix.bean.exception.MatrixException;

public class MatrixFiller extends Thread {
    private Matrix matrix;
    private int a;
    private int b;
    private int value;

    public MatrixFiller(String name, Matrix matrix, int a, int b, int value) {
        super(name);
        this.matrix = matrix;
        this.a = a;
        this.b = b;
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = a; i < b; ++i) {
            try {
                matrix.setElement(i, i, value);
                System.out.println("In " + getName() + " thread");
            } catch (MatrixException e) {
                e.printStackTrace();
            }
        }
    }
}
