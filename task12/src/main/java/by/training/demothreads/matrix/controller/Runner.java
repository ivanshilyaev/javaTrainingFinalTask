package by.training.demothreads.matrix.controller;

import by.training.demothreads.matrix.bean.Matrix;
import by.training.demothreads.matrix.bean.exception.MatrixException;
import by.training.demothreads.matrix.service.v1.MatrixFiller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger();

    private static int readInt(Scanner scanner) {
        int result;
        try {
            result = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            LOGGER.error("Incorrect input");
            result = readInt(scanner);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter way:");
        int ch = readInt(scanner);

        try {
            int n = 12;
            Matrix matrix = new Matrix(n, n);
            int count = n / 3;

            switch (ch) {
                case 1: {
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
                    break;
                }
                case 2: {

                    break;
                }
                case 3: {

                    break;
                }
                case 4: {

                    break;
                }
                case 5: {

                    break;
                }
                default: {
                    System.out.println("Incorrect choice");
                    break;
                }
            }
            System.out.println("Result:");
            System.out.println(matrix);
        } catch (MatrixException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
