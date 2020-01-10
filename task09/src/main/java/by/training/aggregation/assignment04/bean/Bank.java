package by.training.aggregation.assignment04.bean;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Клиент может иметь в банке не более одного счёта в заданной валюте.
 * Всего три валюты => не более трёх счетов */

public class Bank {
    private String name;
    private List<BankAccount> accounts;
    private boolean sort;

    public Bank(String name) {
        this.name = name;
        accounts = new LinkedList<>();
        sort = false;
    }

    public String getName() {
        return name;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public boolean isSorted() {
        return sort;
    }

    public void sortAccounts() {
        Collections.sort(accounts);
        sort = true;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public int calculateAccountNumber() {
        return accounts.size();
    }
}
