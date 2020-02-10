package informationhandlinglight.training.by.bean;

public enum Level {
    TEXT(""),
    PARAGRAPH("[a-zA-Z].*[.?!]\r\n"),
    SENTENCE("[a-zA-Z][^.?!]*[.?!]"),
    LEXEME("\\S+"),
    WORD("\\w+"),
    MARK("\\p{Punct}"),
    SYMBOL("\\S");

    private String pattern;

    Level(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
