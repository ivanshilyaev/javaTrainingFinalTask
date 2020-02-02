package informationhandlinglight.training.by.bean;

public enum Level {
    TEXT(""),
    PARAGRAPH(""),
    SENTENCE(""),
    LEXEME(""),
    WORD(""),
    SYMBOL("");

    private String pattern;

    private Level(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
