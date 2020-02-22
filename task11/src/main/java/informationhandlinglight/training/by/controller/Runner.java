package informationhandlinglight.training.by.controller;

import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.service.ReadCommand;
import informationhandlinglight.training.by.service.SortingCommand;
import informationhandlinglight.training.by.service.parser.ParagraphParser;
import informationhandlinglight.training.by.service.parser.SentenceParser;
import informationhandlinglight.training.by.service.parser.TextParser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ReadCommand readCommand = new ReadCommand();
        String text = readCommand.exec();
        System.out.println("Source text:");
        System.out.println(text);

        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - sort paragraphs by number of sentences");
        System.out.println("2 - sort words in sentence by length");
        System.out.println("3 - sort lexemes by number of a given character");
        System.out.println("Your choice:");
        int ch = 0;
        try {
            ch = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect choice");
            System.exit(1);
        }
        switch (ch) {
            case 1: {
                TextParser textParser = new TextParser(null);
                TextComponent component = textParser.parse(text);
                SortingCommand sortingCommand = new SortingCommand();
                sortingCommand.sortParagraphsByNumberOfSentences(component);
                System.out.println(component.restore());
                break;
            }
            case 2: {
                TextParser textParser = new TextParser(null);
                TextComponent component = textParser.parse(text);
                SortingCommand sortingCommand = new SortingCommand();
                sortingCommand.sortWordsInSentenceByLength(component);
                System.out.println(component.restore());
                break;
            }
            case 3: {
                SentenceParser sentenceParser = new SentenceParser(null);
                ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
                TextParser textParser = new TextParser(paragraphParser);
                TextComponent component = textParser.parse(text);
                SortingCommand sortingCommand = new SortingCommand();
                sortingCommand.sortLexemesByNumberOfGivenCharacter(component, 'a');
                System.out.println(component.restore().toString());
                break;
            }
            default: {
                System.out.println("Incorrect choice");
            }
        }
    }
}
