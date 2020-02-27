package by.training.demothreads.matrixelement.bean;

import by.training.demothreads.matrix.bean.exception.MatrixException;

public class ElementMatrix {
    private Element[][] a;

    public ElementMatrix(int n, int m) throws MatrixException {
        if (n < 1 || m < 1) {
            throw new MatrixException("Invalid size");
        }
        a = new Element[n][m];
    }

    public int getVerticalSize() {
        return a.length;
    }

    public int getHorizontalSize() {
        return a[0].length;
    }

    public Element getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) {
            return a[i][j];
        }
        throw new MatrixException("Invalid index");
    }

    public void setElement(int i, int j, int value) throws MatrixException {
        if (checkRange(i, j)) {
            if (a[i][j] != null) {
                a[i][j].setValue(value);
            } else {
                a[i][j] = new Element(value);
            }
        } else {
            throw new MatrixException("Invalid index");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Matrix: " + getVerticalSize() + "x"
                + getHorizontalSize() + "\n");
        for (Element[] row : a) {
            for (Element element : row) {
                builder.append(element.getValue()).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private boolean checkRange(int i, int j) {
        return i >= 0 && i < getVerticalSize() && j >= 0 && j < getHorizontalSize();
    }
}
