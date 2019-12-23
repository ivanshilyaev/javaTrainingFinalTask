package by.training.oop.assignment01.service;

import by.training.oop.assignment01.bean.Test1;

public class TestService {
    public void update(Test1 test1, int a, int b) {
        test1.setA(a);
        ;
        test1.setB(b);
    }

    public int calculateSum(Test1 test1) {
        return test1.getA() + test1.getB();
    }

    public int calculateMax(Test1 test1) {
        return Math.max(test1.getA(), test1.getB());
    }
}
