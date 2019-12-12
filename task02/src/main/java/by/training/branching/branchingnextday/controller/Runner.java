package by.training.branching.branchingnextday.controller;

import by.training.branching.branchingnextday.service.NextDayCommand;
import by.training.branching.branchingnextday.view.ReadDate;

public class Runner {
    public static void main(String[] args) {
        String data = new ReadDate().read();
        new NextDayCommand().exec(data);
    }
}
