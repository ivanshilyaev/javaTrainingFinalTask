package informationhandlinglight.training.by.service.parser;

import informationhandlinglight.training.by.bean.Level;
import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.bean.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private Parser parser;

    public SentenceParser(Parser parser) {
        this.parser = parser;
    }

    @Override
    public TextComponent parse(String text) {
        if (parser != null) {
            return parser.parse(text);
        } else {
            TextComponent component = new TextComposite(Level.SENTENCE);
            Parser lexemeParser = new LexemeParser();
            Pattern pattern = Pattern.compile(Level.LEXEME.getPattern());
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                component.add(lexemeParser.parse(matcher.group()));
            }
            return component;
        }
    }
}
