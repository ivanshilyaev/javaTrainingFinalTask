package by.training.aggregation.assignment04.bean;

public class BankAccount implements Comparable<BankAccount> {
    private String name;
    private Currency currency;
    private int sum;
    private boolean active;

    public BankAccount(String name, Currency currency, int sum) {
        this.name = name;
        this.currency = currency;
        this.sum = sum;
        active = true;
    }

    public String getName() {
        return name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getSum() {
        return sum;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private void setActive(boolean active) {
        this.active = active;
    }

    public void block() {
        setActive(false);
    }

    public void unblock() {
        setActive(true);
    }


    @Override
    public int compareTo(BankAccount o) {
        double sum1 = 0;
        switch (currency) {
            case USD:
                sum1 = sum;
                break;
            case EUR:
                sum1 = Currency.EUR_TO_USD * sum;
                break;
            case BLR:
                sum1 = Currency.BLR_TO_USD * sum;
                break;
            default:
                break;
        }
        double sum2 = 0;
        switch (o.currency) {
            case USD:
                sum2 = o.sum;
                break;
            case EUR:
                sum2 = Currency.EUR_TO_USD * o.sum;
                break;
            case BLR:
                sum2 = Currency.BLR_TO_USD * o.sum;
                break;
            default:
                break;
        }
        return Double.compare(sum1, sum2);
    }
}
