package ft.training.by.service;

import ft.training.by.dao.Transaction;

public abstract class ServiceImpl implements Service {
    protected Transaction transaction;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
