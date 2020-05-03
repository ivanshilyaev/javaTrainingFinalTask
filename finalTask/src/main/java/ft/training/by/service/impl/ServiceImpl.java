package ft.training.by.service.impl;

import ft.training.by.dao.interfaces.Transaction;
import ft.training.by.service.interfaces.Service;

public abstract class ServiceImpl implements Service {
    protected Transaction transaction;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
