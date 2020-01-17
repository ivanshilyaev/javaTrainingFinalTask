package by.training.final1.assignment01.controller;

import by.training.final1.assignment01.bean.TrainingDirectory;
import by.training.final1.assignment01.bean.TrainingFile;
import by.training.final1.assignment01.service.DirectoryService;
import by.training.final1.assignment01.service.FileService;
import by.training.final1.assignment01.view.ConsoleHelper;
import by.training.final1.assignment01.service.exception.ServiceException;

public class Runner {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        DirectoryService directoryService = new DirectoryService();
        ConsoleHelper consoleHelper = new ConsoleHelper();
        TrainingDirectory directory1 =
                new TrainingDirectory("/Users/ivansilaev/Desktop/test/hello");
        TrainingFile file1 = new TrainingFile(directory1, "input.txt");
        try {
            directoryService.createNewDirectory(directory1);
            fileService.create(file1);
        } catch (ServiceException e) {
            consoleHelper.printMessage(e.getMessage());
        }
    }
}
