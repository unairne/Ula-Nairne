package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightsRetriever {

    public List<Flight> generateFlightsList() {
        List<Flight> flightsList = new ArrayList<>();

        flightsList.add(new Flight("KATOWICE", "WARSZAWA",
                LocalDateTime.of(2020,07,28,15,20),
                LocalDateTime.of(2020, 07,28,16,30)));
        flightsList.add(new Flight("WARSZAWA", "GDANSK",
                LocalDateTime.of(2020,07,28,18,20),
                LocalDateTime.of(2020, 07,28,20,0)));
        flightsList.add(new Flight("GDANSK", "KRAKOW",
                LocalDateTime.of(2020,07,29,15,20),
                LocalDateTime.of(2020, 07,29,17,0)));
        flightsList.add(new Flight("KRAKOW", "WROCLAW",
                LocalDateTime.of(2020,07,29,20,20),
                LocalDateTime.of(2020, 07,29,22,0)));
        flightsList.add(new Flight("WROCLAW", "WARSZAWA",
                LocalDateTime.of(2020,07,30,9,00),
                LocalDateTime.of(2020, 07,30,11,30)));
        flightsList.add(new Flight("KATOWICE", "WARSZAWA",
                LocalDateTime.of(2020,07,30,11,20),
                LocalDateTime.of(2020, 07,30,14,30)));
        flightsList.add(new Flight("WARSZAWA", "GDANSK",
                LocalDateTime.of(2020,07,30,13,20),
                LocalDateTime.of(2020, 07,30,15,0)));
        flightsList.add(new Flight("KATOWICE", "KRAKOW",
                LocalDateTime.of(2019,07,18,11,20),
                LocalDateTime.of(2019, 07,18,14,30)));
        flightsList.add(new Flight("WROCLAW", "GDANSK",
                LocalDateTime.of(2019,07,18,13,20),
                LocalDateTime.of(2019, 07,18,15,0)));

        return flightsList;
    }
}