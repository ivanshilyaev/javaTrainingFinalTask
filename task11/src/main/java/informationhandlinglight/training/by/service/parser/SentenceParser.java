package informationhandlinglight.training.by.service.parser;

import informationhandlinglight.training.by.bean.Level;
import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.bean.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    Parser lexemeParser = new LexemeParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent component = new TextComposite(Level.SENTENCE);
        Pattern pattern = Pattern.compile(Level.LEXEME.getPattern());
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            component.add(lexemeParser.parse(matcher.group()));
        }
        return component;
    }
}
