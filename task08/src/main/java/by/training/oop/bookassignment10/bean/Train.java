package by.training.oop.bookassignment10.bean;

import java.text.SimpleDateFormat;
import java.util.*;

public class Train {
    private String destination;
    private int trainNumber;
    private Date departureTime;
    private Map<Seat, Integer> numberOfSeats;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public Train(String destination) {
        this.destination = destination;
    }

    public Train(String destination, int trainNumber, Date departureTime,
                 int common, int compartment, int openCoupes, int luxury) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        numberOfSeats = new HashMap<>();
        numberOfSeats.put(Seat.COMMON, common);
        numberOfSeats.put(Seat.COMPARTMENT, compartment);
        numberOfSeats.put(Seat.OPEN_COUPES, openCoupes);
        numberOfSeats.put(Seat.LUXURY, luxury);
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Map<Seat, Integer> getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setNumberOfSeats(Map<Seat, Integer> numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trainNumber == train.trainNumber &&
                Objects.equals(destination, train.destination) &&
                Objects.equals(departureTime, train.departureTime) &&
                Objects.equals(numberOfSeats, train.numberOfSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, trainNumber, departureTime, numberOfSeats);
    }

    @Override
    public String toString() {
        return "Train: " +
                "destination = '" + destination + '\'' +
                ", trainNumber = " + trainNumber +
                ", departureTime = " + formatter.format(departureTime) +
                ", numberOfSeats = " + numberOfSeats;
    }
}
