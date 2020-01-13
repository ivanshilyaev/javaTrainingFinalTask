package by.training.final1.assignment04.dao;

import by.training.final1.assignment02.dao.exception.DAOException;
import by.training.final1.assignment04.bean.Treasure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TreasuresReader {
    private int getPrice(Object item) {
        return Integer.parseInt(item.toString());
    }

    public List<Treasure> read(File file, int quantity) throws DAOException {
        ArrayList<Treasure> treasures;
        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            Object[] array = stream.toArray();
            if (array.length != quantity) {
                throw new DAOException("Incorrect quantity of treasures");
            }
            treasures = new ArrayList<>(quantity);
            for (int i = 0; i < quantity; ++i) {
                treasures.add(new Treasure(getPrice(array[i])));
            }
        } catch (NumberFormatException e) {
            throw new DAOException("Incorrect data");
        } catch (IOException e) {
            throw new DAOException("Couldn't read from file", e.getCause());
        }
        return treasures;
    }
}
