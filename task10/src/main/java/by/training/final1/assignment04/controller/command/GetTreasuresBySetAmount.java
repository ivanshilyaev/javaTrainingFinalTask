package by.training.final1.assignment04.controller.command;

import by.training.final1.assignment04.bean.Cave;
import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.repository.ListTreasureRepository;

import java.util.List;

public class GetTreasuresBySetAmount implements Command {
    @Override
    public List<Treasure> exec(Cave cave, int amount) {
        ListTreasureRepository treasureRepository = ListTreasureRepository.getInstance();
        return treasureRepository.findBySetAmount(cave, amount);
    }
}
