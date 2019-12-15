package by.training.branching.branchingnextday.service;

public class Validator {
    public boolean isValid(int[] array) {
        int day = array[0];
        int month = array[1];
        int year = array[2];
        if (day < 1 || month < 1 || month > 12 || year < 1)
            return false;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11: {
                if (day > 30)
                    return false;
                break;
            }
            case 2: {
                if ((!((year % 4 == 0) && (year % 400 != 0)) && day > 28)
                        || (((year % 4 == 0) && (year % 400 != 0)) && day > 29))
                    return false;
                break;
            }
            default:
                if (day > 31)
                    return false;
                break;
        }
        return true;
    }
}
