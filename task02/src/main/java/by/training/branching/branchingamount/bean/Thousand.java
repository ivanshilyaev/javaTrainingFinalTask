package by.training.branching.branchingamount.bean;

public enum Thousand {
    ONE("одна тысяча"),
    TWO("две тысячи"),
    THREE("три тысячи"),
    FOUR("четыре тысячи"),
    FIVE("пять тысяч"),
    SIX("шесть тысяч"),
    SEVEN("семь тысяч"),
    EIGHT("восемь тысяч"),
    NINE("девять тысяч");

    private String thousandText;

    Thousand(String thousandText) {
        this.thousandText = thousandText;
    }

    @Override
    public String toString() {
        return thousandText;
    }
}
