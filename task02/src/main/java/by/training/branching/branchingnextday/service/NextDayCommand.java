package by.training.branching.branchingnextday.service;

import by.training.branching.branchingnextday.bean.Date;

// to fix: сервис не должен выводить результат

public class NextDayCommand {
    public void exec(String data) {
        try {
            Date date = new DataCreator().create(data);
            System.out.println(date.nextDay());
        } catch (IllegalDateException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
