package by.training.final1.assignment04.controller;

import by.training.final1.assignment04.controller.command.*;
import by.training.final1.assignment04.controller.command.exception.CommandException;

import java.util.EnumMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> commandMap = new EnumMap<CommandName, Command>(CommandName.class);

    CommandProvider() {
        commandMap.put(CommandName.GET_ALL_TREASURES, new GetAllTreasures());
        commandMap.put(CommandName.GET_MOST_EXPENSIVE_TREASURE, new GetMostExpensiveTreasure());
        commandMap.put(CommandName.GET_TREASURES_BY_SET_AMOUNT, new GetTreasuresBySetAmount());
    }

    Command getCommand(String name) throws CommandException {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commandMap.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new CommandException("Wrong command", e);
        }
        return command;
    }
}
