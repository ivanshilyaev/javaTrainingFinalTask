package informationhandlinglight.training.by.service.parser;

import informationhandlinglight.training.by.bean.Level;
import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.bean.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements Parser {
    Parser wordParser = new WordParser();
    Parser markParser = new MarkParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent component = new TextComposite(Level.LEXEME);
        Pattern pattern = Pattern.compile(Level.WORD.getPattern());
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            component.add(wordParser.parse(matcher.group()));
        }
        matcher.usePattern(Pattern.compile(Level.MARK.getPattern()));
        while (matcher.find()) {
            component.add(markParser.parse(matcher.group()));
        }
        return component;
    }
}
