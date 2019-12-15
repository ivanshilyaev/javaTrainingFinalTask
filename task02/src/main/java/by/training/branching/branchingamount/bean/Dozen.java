package by.training.branching.branchingamount.bean;

public enum Dozen {
    ZERO(""),
    ONE(""),
    TWO("двадцать"),
    THREE("тридцать"),
    FOUR("сорок"),
    FIVE("пятьдесят"),
    SIX("шестьдесят"),
    SEVEN("семьдесят"),
    EIGHT("восемьдесят"),
    NINE("девяносто");

    private String dozenText;

    Dozen(String dozenText) {
        this.dozenText = dozenText;
    }

    @Override
    public String toString() {
        return dozenText;
    }
}
