package by.training.branching.branchingnextday.service;

import by.training.branching.branchingnextday.bean.Date;

// creates Date object from String

public class DataCreator {
    public Date create(String data) throws IllegalDateException {
        String[] tmp = data.split(" ");
        int[] array = new int[3];
        for (int i = 0; i < 3; ++i) {
            array[i] = Integer.parseInt(tmp[i]);
        }
        if (!new Validator().isValid(array))
            throw new IllegalDateException("Incorrect data");
        return new Date(array[0], array[1], array[2]);
    }
}
