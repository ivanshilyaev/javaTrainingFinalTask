package by.training.demothreads.matrixelement.controller;

import by.training.demothreads.matrix.bean.exception.MatrixException;
import by.training.demothreads.matrixelement.bean.ElementMatrix;
import by.training.demothreads.matrixelement.service.CheckFiller;
import by.training.demothreads.matrixelement.service.ElementMatrixFiller;
import by.training.demothreads.matrixelement.service.ThreadDiagonalFiller;
import by.training.demothreads.matrixelement.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Каждый поток заполняет случайные эелемнты матрицы своим значением.
 * Затем запускается ещё один поток, который проверяет, все ли элементы
 * запонены, и заполняет оставшиеся "пустые" элементы.
 */

public class Runner {
    public static void main(String[] args) {
        try {
            int n = 12;
            int threadNumber = 4;
            ElementMatrix matrix = new ElementMatrix(n, n);
            ElementMatrixFiller matrixFiller = new ElementMatrixFiller();
            matrixFiller.emptyMatrix(matrix);

            List<Thread> threads = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < threadNumber - 1; ++i) {
                ThreadDiagonalFiller filler = new ThreadDiagonalFiller(matrix, i + 1);
                filler.setPriority(1 + random.nextInt(10));
                System.out.println(filler.getName());
                System.out.println("Priority: " + filler.getPriority());
                threads.add(filler);
            }
            for (Thread thread : threads) {
                thread.start();
                thread.join();
            }
            Thread thread = new CheckFiller(matrix, threadNumber);
            thread.start();
            thread.join();

            System.out.println(matrix);
        } catch (MatrixException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
