package by.training.twodimensionalarrays.exampletask.parser;

import by.training.twodimensionalarrays.exampletask.parser.exception.ParserException;

public class Parser {
    public int[] parse(String line, int size) throws ParserException {
        String[] array = line.split(" ");
        if (array.length != size) {
            throw new ParserException("Incompatible size");
        }
        int[] result = new int[size];
        try {
            for (int i = 0; i < array.length; ++i) {
                result[i] = Integer.parseInt(array[i]);
            }
        } catch (NumberFormatException e) {
            throw new ParserException("Couldn't parse string to int");
        }
        return result;
    }
}
