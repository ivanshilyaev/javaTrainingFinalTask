package by.training.final1.assignment02.controller;

import by.training.final1.assignment02.bean.Payment;
import by.training.final1.assignment02.service.PaymentService;
import by.training.final1.assignment02.service.WriteChequeCommand;
import by.training.final1.assignment02.service.exception.ServiceException;
import by.training.final1.assignment02.view.ConsoleHelper;

import java.io.File;

public class Runner {
    private final static String FILE_IN = "/Users/ivansilaev/Desktop/javaTraining/task10/src/main/java/by/training/final1/assignment02/resources/input.txt";
    private final static String FILE_OUT = "/Users/ivansilaev/Desktop/javaTraining/task10/src/main/java/by/training/final1/assignment02/resources/output.txt";

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
        Payment payment = new Payment();
        PaymentService service = PaymentService.getInstance();
        File input = new File(FILE_IN);
        File output = new File(FILE_OUT);
        try {
            service.addCommodities(payment, input);
            new WriteChequeCommand().write(service.getPaymentCheque(payment), output);
        } catch (ServiceException e) {
            consoleHelper.printMessage(e.getMessage());
        }
    }
}
