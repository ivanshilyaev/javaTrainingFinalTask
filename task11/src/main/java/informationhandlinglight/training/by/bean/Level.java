package informationhandlinglight.training.by.bean;

public enum Level {
    TEXT(""),
    PARAGRAPH("[a-zA-Z].*[.?!]\r\n"),
    SENTENCE("[a-zA-Z][^.?!]*[.?!]"),
    LEXEME("\\S+"),
    WORD("\\w+"),
    SYMBOL("\\S");

    private String pattern;

    private Level(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
