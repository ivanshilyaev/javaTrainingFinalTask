package by.training.branching.branchingnextday.service;

import by.training.branching.branchingnextday.bean.Date;

public class NextDayCommand {
    public String exec(String data) throws IllegalDateException {
        Date date = new DataCreator().create(data);
        return date.nextDay().toString();
    }
}
