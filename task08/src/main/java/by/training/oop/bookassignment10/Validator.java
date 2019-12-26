package by.training.oop.bookassignment10;

import by.training.oop.bookassignment10.bean.Seat;
import by.training.oop.bookassignment10.bean.Train;

import java.util.Date;
import java.util.Map;

public class Validator {
    public static boolean isValid(Train train) {
        if (train.getTrainNumber() <= 0) {
            return false;
        }
        if ((new Date()).compareTo(train.getDepartureTime()) > 0) {
            return false;
        }
        for (Map.Entry<Seat, Integer> entry : train.getNumberOfSeats().entrySet()) {
            if (entry.getValue() < 0) {
                return false;
            }
        }
        return true;
    }
}
