package informationhandlinglight.training.by.controller;

import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.bean.TextComposite;
import informationhandlinglight.training.by.service.ReadCommand;
import informationhandlinglight.training.by.service.SortingCommand;
import informationhandlinglight.training.by.service.parser.ParagraphParser;
import informationhandlinglight.training.by.service.parser.SentenceParser;
import informationhandlinglight.training.by.service.parser.TextParser;

public class Runner {
    private static final String DEL = "---";

    public static void main(String[] args) {
        ReadCommand readCommand = new ReadCommand();
        String text = readCommand.exec();
        SentenceParser sentenceParser = new SentenceParser(null);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        TextParser textParser = new TextParser(null);
        TextComponent component = textParser.parse(text);

        /*
        TextComposite textComposite = (TextComposite) textParser.parse(text.toString());
        for (int i = 0; i < textComposite.getComponentsSize(); ++i) {
            System.out.println(textComposite.getChild(i).restore());
            System.out.println(DEL);
        }
        for (int i = 0; i < ((TextComposite) component).getComponentsSize(); ++i) {
            System.out.println(((TextComposite) component.getChild(i)).getComponentsSize());
        }

         */

        /*
         * 1
        SortingCommand sortingCommand = new SortingCommand();
        sortingCommand.sortParagraphsByNumberOfSentences(component);
         */

        /*
         * 2
        SortingCommand sortingCommand = new SortingCommand();
        sortingCommand.sortWordsInSentenceByLength(component);
         */

        /*
         * 3
         */

        SentenceParser sentenceParser1 = new SentenceParser(null);
        ParagraphParser paragraphParser1 = new ParagraphParser(sentenceParser1);
        TextParser textParser1 = new TextParser(paragraphParser1);
        TextComponent component1 = textParser1.parse(text);

        System.out.println(component1.restore().toString());

        SortingCommand sortingCommand = new SortingCommand();
        sortingCommand.sortLexemesByNumberOfGivenCharacter(component1, 'a');

        System.out.println(component1.restore().toString());
    }
}
