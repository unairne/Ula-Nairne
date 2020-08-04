package com.kodilla.good.patterns.challenges.flights;

public class Application {

    public static void main(String[] args) {

        FlightsRetriever flightsRetriever = new FlightsRetriever();
        FlightSearcher flightSearcher = new FlightSearcher(flightsRetriever.generateFlightsList());

        flightSearcher.searchFlightFrom("KATOWICE");
        flightSearcher.searchFlightTo("GDANSK");
        flightSearcher.searchFlightConnection("KATOWICE", "GDANSK");
    }
}
