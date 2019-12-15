package by.training.branching.branchingamount.bean;

public enum Unit {
    ZERO(""),
    ONE("один"),
    TWO("два"),
    THREE("три"),
    FOUR("четыре"),
    FIVE("пять"),
    SIX("шесть"),
    SEVEN("семь"),
    EIGHT("восемь"),
    NINE("девять");

    private String unitText;

    Unit(String unitText) {
        this.unitText = unitText;
    }

    @Override
    public String toString() {
        return unitText;
    }
}
