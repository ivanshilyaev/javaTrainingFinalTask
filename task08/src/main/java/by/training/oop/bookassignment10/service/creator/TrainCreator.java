package by.training.oop.bookassignment10.service.creator;

import by.training.oop.bookassignment10.bean.Seat;
import by.training.oop.bookassignment10.bean.Train;
import by.training.oop.bookassignment10.service.creator.exception.CreationException;

import java.util.*;

public class TrainCreator {
    private int randomBetween(int start, int finish) {
        return start + (int) (Math.round(Math.random() * (finish - start)));
    }

    private Date getRandomDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randomBetween(2020, 2021);
        gc.set(Calendar.YEAR, year);
        int day = randomBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, day);
        int hour = randomBetween(1, 23);
        gc.set(Calendar.HOUR, hour);
        int minute = randomBetween(1, 59);
        gc.set(Calendar.MINUTE, minute);
        return gc.getTime();
    }

    private void fillRandomly(Train train) {
        Random random = new Random();
        train.setTrainNumber(1 + (Math.abs(random.nextInt()) % 1000));
        train.setDepartureTime(getRandomDate());
        EnumMap<Seat, Integer> numberOfSeats = new EnumMap<>(Seat.class);
        numberOfSeats.put(Seat.COMMON, (Math.abs(random.nextInt()) % 100));
        numberOfSeats.put(Seat.COMPARTMENT, (Math.abs(random.nextInt()) % 100));
        numberOfSeats.put(Seat.OPEN_COUPES, (Math.abs(random.nextInt()) % 100));
        numberOfSeats.put(Seat.LUXURY, (Math.abs(random.nextInt()) % 100));
        train.setNumberOfSeats(numberOfSeats);
    }

    public Train[] createTrainArray(int size) throws CreationException {
        Train[] trains = new Train[10];
        CityCreator cityCreator = new CityCreator();
        for (int i = 0; i < 10; ++i) {
            trains[i] = new Train(cityCreator.getRandomCity());
            fillRandomly(trains[i]);
        }
        return trains;
    }
}
