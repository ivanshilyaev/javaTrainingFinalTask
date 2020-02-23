package by.training.demothreads.matrix.controller;

import by.training.demothreads.matrix.bean.Matrix;
import by.training.demothreads.matrix.bean.exception.MatrixException;
import by.training.demothreads.matrix.service.MatrixFiller;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            int n = 30;
            Matrix matrix = new Matrix(n, n);
            int count = n / 3;
            List<MatrixFiller> threads = new ArrayList<>();
            for (int i = 0; i < n / count; ++i) {
                MatrixFiller filler = new MatrixFiller("filler " + (i + 1), matrix,
                        i * count, (i + 1) * count, i + 1);
                threads.add(filler);
            }
            threads.get(2).setPriority(Thread.MAX_PRIORITY);
            threads.get(0).setPriority(Thread.MIN_PRIORITY);
            for (MatrixFiller filler : threads) {
                filler.start();
                filler.join();
            }
            System.out.println(matrix);
        } catch (MatrixException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
