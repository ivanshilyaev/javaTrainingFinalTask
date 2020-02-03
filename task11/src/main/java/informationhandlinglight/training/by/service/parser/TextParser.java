package informationhandlinglight.training.by.service.parser;

import informationhandlinglight.training.by.bean.Level;
import informationhandlinglight.training.by.bean.TextComponent;
import informationhandlinglight.training.by.bean.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements Parser {
    Parser paragraphParser = new ParagraphParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent component = new TextComposite(Level.TEXT);
        Pattern pattern = Pattern.compile(Level.PARAGRAPH.getPattern());
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            component.add(paragraphParser.parse(matcher.group()));
        }

        return component;
    }
}
