package by.training.branching.controller;

import java.util.Scanner;

public class Runner21 {
    public static void flatter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Кто ты: мальчик или девочка? Введи Д или М");
        String choice = scanner.nextLine();
        switch (choice) {
            case "Д": {
                System.out.println("Мне нравятся девочки!");
                break;
            }
            case "М": {
                System.out.println("Мне нравятся мальчики!");
                break;
            }
            default:
                System.out.println("Похоже, ты ввёл неверные данные, " +
                        "но ты мне всё равно нравишься!");
                break;
        }
    }

    public static void main(String[] args) {
        flatter();
    }
}
