package by.training.branching.brangingseasons.service;

import by.training.branching.brangingseasons.bean.Season;

import java.util.InputMismatchException;

public class SeasonCommand {
    public Season exec(String data) {
        Season season;
        int month = Integer.parseInt(data);
        switch (month) {
            case 12:
            case 1:
            case 2:
                season = Season.WINTER;
                break;
            case 3:
            case 4:
            case 5:
                season = Season.SPRING;
                break;
            case 6:
            case 7:
            case 8:
                season = Season.SUMMER;
                break;
            case 9:
            case 10:
            case 11:
                season = Season.AUTUMN;
                break;
            default:
                throw new InputMismatchException("Incorrect data");
        }
        return season;
    }
}
