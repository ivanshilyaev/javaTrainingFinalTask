package by.training.branching.brangingseasons.service;

import by.training.branching.brangingseasons.bean.Season;

import java.util.InputMismatchException;

// using new switch

public class SeasonCommand {
    public Season exec(String data) {
        int month = Integer.parseInt(data);
        return switch (month) {
            case 12, 1, 2 -> Season.WINTER;
            case 3, 4, 5 -> Season.SPRING;
            case 6, 7, 8 -> Season.SUMMER;
            case 9, 10, 11 -> Season.AUTUMN;
            default -> throw new InputMismatchException();
        };
    }
}
