package ft.training.by.dao.interfaces;

public interface TransactionFactory {
    Transaction createTransaction();

    void close();
}
