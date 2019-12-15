package by.training.branching.branchingamount.bean;

public enum TenToNineteen {
    ZERO("десять"),
    ONE("одиннадцать"),
    TWO("двенадцать"),
    THREE("тринадцать"),
    FOUR("четырнадцать"),
    FIVE("пятнадцать"),
    SIX("шестнадцать"),
    SEVEN("семнадцать"),
    EIGHT("восемнадцать"),
    NINE("девятнадцать");

    private String unitText;

    TenToNineteen(String unitText) {
        this.unitText = unitText;
    }

    @Override
    public String toString() {
        return unitText;
    }
}
