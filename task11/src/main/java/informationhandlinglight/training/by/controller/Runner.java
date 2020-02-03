package informationhandlinglight.training.by.controller;

import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.service.parser.TextParser;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        while (scanner.hasNext()) {
            text.append(scanner.nextLine()).append("\r\n");
        }
        TextParser textParser = new TextParser();
        TextComponent textComponent = textParser.parse(text.toString());
        System.out.println(textComponent.restore().toString());
    }
}
