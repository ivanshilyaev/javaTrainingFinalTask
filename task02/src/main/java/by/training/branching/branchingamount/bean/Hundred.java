package by.training.branching.branchingamount.bean;

public enum Hundred {
    ONE("сто"),
    TWO("двести"),
    THREE("триста"),
    FOUR("четыреста"),
    FIVE("пятьсот"),
    SIX("шестьсот"),
    SEVEN("семьсот"),
    EIGHT("восемьсот"),
    NINE("девятьсот");

    private String hundredText;

    Hundred(String hundredText) {
        this.hundredText = hundredText;
    }

    @Override
    public String toString() {
        return hundredText;
    }
}
