package by.training.final1.assignment02.controller;

import by.training.final1.assignment02.bean.Payment;
import by.training.final1.assignment02.service.PaymentService;
import by.training.final1.assignment02.service.WriteChequeCommand;
import by.training.final1.assignment02.service.exception.ServiceException;
import by.training.final1.assignment02.view.ConsoleHelper;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
        Payment payment = new Payment();
        PaymentService service = PaymentService.getInstance();
        File input = new File("/Users/ivansilaev/Desktop/javaTraining/task10/src/main/java/by/training/final1/assignment02/resources/input.txt");
        File output = new File("/Users/ivansilaev/Desktop/javaTraining/task10/src/main/java/by/training/final1/assignment02/resources/output.txt");
        try {
            service.addCommodities(payment, input);
            new WriteChequeCommand().write(service.getPaymentCheque(payment), output);
        } catch (ServiceException e) {
            consoleHelper.printMessage(e.getMessage());
        }
    }
}
