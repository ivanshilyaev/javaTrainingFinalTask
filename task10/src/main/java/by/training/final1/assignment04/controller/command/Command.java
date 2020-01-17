package by.training.final1.assignment04.controller.command;

import by.training.final1.assignment04.bean.Cave;
import by.training.final1.assignment04.bean.Treasure;

import java.util.List;

public interface Command {
    List<Treasure> exec(Cave cave, int amount);
}
