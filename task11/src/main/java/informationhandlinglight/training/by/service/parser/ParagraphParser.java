package informationhandlinglight.training.by.service.parser;

import informationhandlinglight.training.by.bean.Level;
import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.bean.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {
    private Parser parser;

    public ParagraphParser(Parser parser) {
        this.parser = parser;
    }

    @Override
    public TextComponent parse(String text) {
        if (parser != null) {
            return parser.parse(text);
        } else {
            TextComponent component = new TextComposite(Level.PARAGRAPH);
            Parser sentenceParser = new SentenceParser(null);
            Pattern pattern = Pattern.compile(Level.SENTENCE.getPattern());
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                component.add(sentenceParser.parse(matcher.group()));
            }
            return component;
        }
    }
}
