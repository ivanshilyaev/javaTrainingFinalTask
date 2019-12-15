package by.training.branching.branchingnextday.controller;

import by.training.branching.branchingnextday.service.IllegalDateException;
import by.training.branching.branchingnextday.service.NextDayCommand;
import by.training.branching.branchingnextday.view.ReadDate;

public class Runner {
    public static void main(String[] args) {
        try {
            String data = new ReadDate().read();
            System.out.println(new NextDayCommand().exec(data));
        } catch (IllegalDateException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
