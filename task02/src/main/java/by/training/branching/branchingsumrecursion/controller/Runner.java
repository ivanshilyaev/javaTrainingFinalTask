package by.training.branching.branchingsumrecursion.controller;

import java.util.ArrayList;

public class Runner {
    public static int sum(ArrayList<Integer> numbers, int counter) {
        if (counter == 0) {
            return numbers.get(counter);
        } else {
            return numbers.get(counter) + sum(numbers, --counter);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            numbers.add(i + 1);
        }
        int sum = 0;
        for (int i = 0; i < numbers.size(); ++i) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
        System.out.println(sum(numbers, 99));
    }
}
