package by.training.oop.bookassignment10.dao;

import by.training.oop.bookassignment10.dao.exception.DAOException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class CityReader {
    private static String fileName = "/Users/ivansilaev/Desktop/javaTraining/task08/src/main/java/by/training/oop/bookassignment10/resources/cities.txt";

    public String readRandomCity() throws DAOException {
        Random random = new Random();
        int index = Math.abs(random.nextInt()) % 300;
        return readAllCities()[index];
    }

    public String[] readAllCities() throws DAOException {
        String[] entries = null;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            Object[] array = stream.toArray();
            entries = Arrays.copyOf(array, array.length, String[].class);
        } catch (IOException e) {
            throw new DAOException("Couldn't read from file", e.getCause());
        }
        String[] cities = new String[entries.length];
        for (int i = 0; i < entries.length; ++i) {
            String[] array = entries[i].split("[^a-zA-Z0-9]");
            cities[i] = array[1];
        }
        return cities;
    }
}
