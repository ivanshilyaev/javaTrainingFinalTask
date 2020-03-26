package ft.training.by.dao;

public interface TransactionFactory {
    Transaction createTransaction();

    void close();
}
