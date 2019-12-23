package by.training.oop.assignment01.view;

import by.training.oop.assignment01.bean.Test1;

public class UserInterface {
    public void printObject(Test1 test1) {
        System.out.println(test1.toString());
    }

    public void printInt(String message, int a) {
        System.out.println(message);
        System.out.println(a);
    }
}