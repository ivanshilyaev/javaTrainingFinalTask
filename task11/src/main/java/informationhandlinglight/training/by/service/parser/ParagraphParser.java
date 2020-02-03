package informationhandlinglight.training.by.service.parser;

import informationhandlinglight.training.by.bean.Level;
import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.bean.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {
    Parser sentenceParser = new SentenceParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent component = new TextComposite(Level.PARAGRAPH);
        Pattern pattern = Pattern.compile(Level.SENTENCE.getPattern());
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            component.add(sentenceParser.parse(matcher.group()));
        }
        return component;
    }
}
