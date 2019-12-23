package by.training.twodimensionalarrays.exampletask.bean;


import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;

public class Matrix {
    private int[][] a;

    public Matrix(int n, int m) throws MatrixException {
        if (n < 1 || m < 1) {
            throw new MatrixException("Invalid size");
        }
        a = new int[n][m];
    }

    public int getVerticalSize() {
        return a.length;
    }

    public int getHorizontalSize() {
        return a[0].length;
    }

    public int getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) {
            return a[i][j];
        }
        throw new MatrixException("Invalid index");
    }

    public void setElement(int i, int j, int value) throws MatrixException {
        if (checkRange(i, j)) {
            a[i][j] = value;
        } else {
            throw new MatrixException("Invalid index");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Matrix: " + getVerticalSize() + "x"
                + getHorizontalSize() + "\n");
        for (int[] row : a) {
            for (int value : row) {
                builder.append(value).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private boolean checkRange(int i, int j) {
        return i >= 0 && i < getVerticalSize() && j >= 0 && j < getHorizontalSize();
    }
}
