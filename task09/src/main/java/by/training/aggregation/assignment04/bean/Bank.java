package by.training.aggregation.assignment04.bean;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;
    private boolean sort;

    public Bank() {
        accounts = new LinkedList<>();
        sort = false;
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

    public int calculateAccountNumber() {
        return accounts.size();
    }
}
