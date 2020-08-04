package com.kodilla.good.patterns.challenges.flights;

public class FlightConnection {
    private Flight firstFlight;
    private Flight secondFlight;

    public FlightConnection(Flight firstFlight, Flight secondFlight) {
        this.firstFlight = firstFlight;
        this.secondFlight = secondFlight;
    }

    public Flight getFirstFlight() {
        return firstFlight;
    }

    public Flight getSecondFlight() {
        return secondFlight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightConnection)) return false;

        FlightConnection that = (FlightConnection) o;

        if (firstFlight != null ? !firstFlight.equals(that.firstFlight) : that.firstFlight != null) return false;
        return secondFlight != null ? secondFlight.equals(that.secondFlight) : that.secondFlight == null;
    }

    @Override
    public int hashCode() {
        int result = firstFlight != null ? firstFlight.hashCode() : 0;
        result = 31 * result + (secondFlight != null ? secondFlight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlightConnection{" +
                "firstFlight=" + firstFlight +
                ", secondFlight=" + secondFlight +
                '}';
    }
}