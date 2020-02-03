package informationhandlinglight.training.by.service.parser;

import informationhandlinglight.training.by.bean.TextComponent;

public interface Parser {
    TextComponent parse(String text);
}
