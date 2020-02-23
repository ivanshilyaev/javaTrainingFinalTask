package by.training.demothreads.matrix.service;

import by.training.demothreads.matrix.bean.Matrix;

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
            matrix.setElement(i, i, value);
            System.out.println("In " + getName() + " thread");
        }
    }
}
