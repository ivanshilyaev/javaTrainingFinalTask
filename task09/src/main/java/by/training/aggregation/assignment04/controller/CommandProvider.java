package by.training.aggregation.assignment04.controller;

import by.training.aggregation.assignment04.controller.command.*;
import by.training.aggregation.assignment04.controller.command.exception.CommandException;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.GET_TOTAL_AMOUNT, new TotalAmount());
        repository.put(CommandName.GET_TOTAL_POSITIVE_AMOUNT, new TotalPositiveAmount());
        repository.put(CommandName.GET_TOTAL_NEGATIVE_AMOUNT, new TotalNegativeAmount());
    }

    Command getCommand(String name) throws CommandException {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new CommandException("Wrong command", e);
        }
        return command;
    }
}
