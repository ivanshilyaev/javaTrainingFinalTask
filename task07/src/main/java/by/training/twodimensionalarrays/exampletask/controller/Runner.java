package by.training.twodimensionalarrays.exampletask.controller;

import by.training.twodimensionalarrays.exampletask.bean.Matrix;
import by.training.twodimensionalarrays.exampletask.bean.exception.MatrixException;
import by.training.twodimensionalarrays.exampletask.service.action.Multiplicator;
import by.training.twodimensionalarrays.exampletask.service.creator.MatrixCreator;

public class Runner {
    public static void main(String[] args) {
        try {
            MatrixCreator creator = new MatrixCreator();
            Matrix p = new Matrix(2, 3);
            creator.fillRandomized(p, 1, 5);
            System.out.println(p);
            Matrix q = new Matrix(3, 2);
            creator.fillRandomized(q, 1, 3);
            System.out.println(q);
            Multiplicator multiplicator = new Multiplicator();
            Matrix result = multiplicator.multiply(p, q);
            System.out.println(result);
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }

    }
}
