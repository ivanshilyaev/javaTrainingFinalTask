package by.training.final1.assignment02.service;

import by.training.final1.assignment02.bean.Payment;
import by.training.final1.assignment02.service.exception.ServiceException;

import java.io.File;

public final class PaymentService {
    private static final PaymentService INSTANCE = new PaymentService();

    private PaymentService() {
    }

    public static PaymentService getInstance() {
        return INSTANCE;
    }

    public void addCommodity(Payment payment, String name, double price, double discount) {
        payment.addCommodity(name, price, discount);
    }

    public void addCommodity(Payment payment, String name, double price, double discount,
                             int quantity) {
        payment.addCommodity(name, price, discount, quantity);
    }

    /*
     * Сервис и считывает информацию, и парсит её, и валидирует.
     * Необходимо разбить всё на три разные команды.
     */
    public void addCommodities(Payment payment, File file) throws ServiceException {
        ReadCommodityCommand command = ReadCommodityCommand.getInstance();
        String[] data = command.read(file);
        try {
            for (String line : data) {
                String[] array = line.split(" ");
                /*
                 * all the parameters except amount.
                 * amount is calculated
                 */
                if (array.length != 5) {
                    throw new ServiceException("Incorrect data");
                }
                String barcode = array[0];
                String name = array[1];
                double price = Double.parseDouble(array[2]);
                double discount = Double.parseDouble(array[3]);
                int quantity = Integer.parseInt(array[4]);
                payment.addCommodity(barcode, name, price, discount, quantity);
            }
        } catch (NumberFormatException e) {
            throw new ServiceException("Incorrect data");
        }
    }

    public String getPaymentCheque(Payment payment) {
        return payment.getCheque();
    }
}
