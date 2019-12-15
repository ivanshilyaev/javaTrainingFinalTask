package by.training.cycles.cycles20.controller;

import by.training.cycles.cycles20.service.CountCommand;

public class Runner {
    private static final double eps = Math.pow(10, -9);

    public static void main(String[] args) {
        System.out.println(new CountCommand().exec(eps));
    }
}
