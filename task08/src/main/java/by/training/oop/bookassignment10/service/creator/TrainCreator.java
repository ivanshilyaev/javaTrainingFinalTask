package by.training.oop.bookassignment10.service.creator;

import by.training.oop.bookassignment10.bean.Seat;
import by.training.oop.bookassignment10.bean.Train;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TrainCreator {
    public void fillRandomly(Train train) {
        Random random = new Random();
        train.setTrainNumber(1 + (Math.abs(random.nextInt()) % 1000));
        train.setDepartureTime(new Date());
        Map<Seat, Integer> numberOfSeats = new HashMap();
        numberOfSeats.put(Seat.COMMON, (Math.abs(random.nextInt()) % 100));
        numberOfSeats.put(Seat.COMPARTMENT, (Math.abs(random.nextInt()) % 100));
        numberOfSeats.put(Seat.OPEN_COUPES, (Math.abs(random.nextInt()) % 100));
        numberOfSeats.put(Seat.LUXURY, (Math.abs(random.nextInt()) % 100));
        train.setNumberOfSeats(numberOfSeats);
    }
}
