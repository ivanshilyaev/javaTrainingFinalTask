package by.training.methods.methods10.controller;

import by.training.methods.methods10.service.CountCommand;

public class Runner {
    private static final int NUMBER = 9;

    public static void main(String[] args) {
        CountCommand command = new CountCommand();
        System.out.println(command.exec(NUMBER));
    }
}
