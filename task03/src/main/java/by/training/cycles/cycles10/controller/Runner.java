package by.training.cycles.cycles10.controller;

import by.training.cycles.cycles10.service.CountCommand;

public class Runner {
    public static void main(String[] args) {
        int[] result = new int[1000];
        int size = new CountCommand().exec(result);
        for (int i = size - 1; i >= 0; --i) {
            System.out.print(result[i]);
        }
        System.out.println();
    }
}
