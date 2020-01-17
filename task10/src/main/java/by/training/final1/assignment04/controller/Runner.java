package by.training.final1.assignment04.controller;

import by.training.final1.assignment04.bean.Cave;
import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.controller.command.Command;
import by.training.final1.assignment04.controller.command.exception.CommandException;
import by.training.final1.assignment04.service.CaveService;
import by.training.final1.assignment04.service.exception.ServiceException;
import by.training.final1.assignment04.view.ConsoleHelper;

import java.io.File;
import java.util.List;

public class Runner {
    private static final String FILE_IN = "/Users/ivansilaev/Desktop/javaTraining/task10/src/main/java/by/training/final1/assignment04/resources/input.txt";
    private static final String FILE_OUT = "/Users/ivansilaev/Desktop/javaTraining/task10/src/main/java/by/training/final1/assignment04/resources/output.txt";
    private static final String COMMANDS = "/Users/ivansilaev/Desktop/javaTraining/task10/src/main/java/by/training/final1/assignment04/resources/commands.txt";

    public static void main(String[] args) {
        CommandProvider commandProvider = new CommandProvider();
        ConsoleHelper consoleHelper = new ConsoleHelper();
        CaveService caveService = new CaveService();
        Cave cave = new Cave();
        File outFile = new File(FILE_OUT);
        try {
            caveService.addTreasures(cave, new File(FILE_IN));
            String[] listOfCommands = caveService.readListOfCommands(new File(COMMANDS));
            for (String item : listOfCommands) {
                String[] array = item.split(" ");
                Command command = commandProvider.getCommand(array[0]);
                List<Treasure> treasures;
                if (array.length == 1) {
                    treasures = command.exec(cave, 0);
                } else {
                    treasures = command.exec(cave, Integer.parseInt(array[1]));
                }
                caveService.writeResponse(treasures.toString(), outFile);
            }
        } catch (ServiceException e) {
            consoleHelper.printMessage(e.getMessage());
        } catch (CommandException e) {
            consoleHelper.printMessage(e.getMessage());
        }
    }
}
