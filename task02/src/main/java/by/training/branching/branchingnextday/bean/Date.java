package by.training.branching.branchingnextday.bean;

import java.util.Objects;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
        day = 1;
        month = 1;
        year = 1970;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date nextDay() {
        int newDay = day;
        int newMonth = month;
        int newYear = year;
        switch (newMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (newDay == 30) {
                    ++newMonth;
                    newDay = 1;
                } else {
                    ++newDay;
                }
                break;
            case 2:
                if ((isLeap() && newDay == 29) || (!isLeap() && newDay == 28)) {
                    ++newMonth;
                    newDay = 1;
                } else {
                    ++newDay;
                }
                break;
            default:
                if (newDay == 31) {
                    ++newMonth;
                    newDay = 1;
                } else {
                    ++newDay;
                }
                break;
        }
        if (newMonth == 13) {
            newMonth = 1;
            ++newYear;
        }
        return new Date(newDay, newMonth, newYear);
    }

    public boolean isLeap() {
        return (year % 4 == 0) && (year % 400 != 0);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (day < 10)
            builder.append(0);
        builder.append(day).append(".");
        if (month < 10)
            builder.append(0);
        builder.append(month).append(".").append(year);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }
}
