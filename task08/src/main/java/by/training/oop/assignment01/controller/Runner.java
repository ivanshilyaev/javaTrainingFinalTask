package by.training.oop.assignment01.controller;

import by.training.oop.assignment01.bean.Test1;
import by.training.oop.assignment01.service.TestService;
import by.training.oop.assignment01.view.UserInterface;

public class Runner {
    public static void main(String[] args) {
        Test1 test1 = new Test1(1, 2);
        UserInterface anInterface = new UserInterface();
        TestService service = new TestService();
        anInterface.printObject(test1);
        service.update(test1, 2, 3);
        anInterface.printObject(test1);
        anInterface.printInt("Sum:", service.calculateSum(test1));
        anInterface.printInt("Max:", service.calculateMax(test1));
    }
}
