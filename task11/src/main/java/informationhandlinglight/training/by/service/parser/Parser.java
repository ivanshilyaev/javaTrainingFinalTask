package informationhandlinglight.training.by.service.parser;

import informationhandlinglight.training.by.bean.TextComponent;

// Handler in Chain of Responsibility
public interface Parser {
    TextComponent parse(String text);
}
