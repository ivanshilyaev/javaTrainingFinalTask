package by.training.branching.brangingseasons.controller;

import by.training.branching.brangingseasons.bean.Season;
import by.training.branching.brangingseasons.service.SeasonCommand;
import by.training.branching.brangingseasons.view.ReadData;

import java.util.InputMismatchException;

public class Runner {
    public static void main(String[] args) {
        try {
            String data = new ReadData().read();
            Season season = new SeasonCommand().exec(data);
            System.out.println(season.toString());
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
