package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalDateTime;

public class Flight {

    private final String departureCity;
    private final String arrivalCity;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;

    public Flight(String departureCity, String arrivalCity, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (!departureCity.equals(flight.departureCity)) return false;
        if (!arrivalCity.equals(flight.arrivalCity)) return false;
        if (!departureTime.equals(flight.departureTime)) return false;
        return arrivalTime.equals(flight.arrivalTime);
    }

    @Override
    public int hashCode() {
        int result = departureCity.hashCode();
        result = 31 * result + arrivalCity.hashCode();
        result = 31 * result + departureTime.hashCode();
        result = 31 * result + arrivalTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}