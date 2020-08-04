package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FlightSearcher {

    private List<Flight> temporaryList;

    public FlightSearcher(List<Flight> flightsList) {
        temporaryList = flightsList;
    }

    public List<Flight> searchFlightFrom(String departureCity) {
        List<Flight> flightsFrom = temporaryList.stream()
                .filter(f -> f.getDepartureCity().equals(departureCity))
                .filter(f -> LocalDateTime.now().isBefore(f.getDepartureTime()))
                .collect(Collectors.toList());

        System.out.println("\nFLIGHTS FROM: " + departureCity);
        flightsFrom.forEach(flight -> System.out.println(""+flight));
        return flightsFrom;
    }

    public List<Flight> searchFlightTo(String arrivalCity) {
        List<Flight> flightsTo = temporaryList.stream()
                .filter(f -> f.getArrivalCity().equals(arrivalCity))
                .filter(f -> LocalDateTime.now().isBefore(f.getDepartureTime()))
                .collect(Collectors.toList());

        System.out.println("\nFLIGHTS TO: " + arrivalCity);
        flightsTo.forEach(System.out::println);
        return flightsTo;
    }

    public List<FlightConnection> searchFlightConnection(String departureCity, String arrivalCity) {
        List<Flight> flightsConnection = temporaryList.stream()
                .filter(f ->
                        f.getArrivalCity().equals(arrivalCity) || f.getDepartureCity().equals(departureCity))
                .collect(Collectors.toList());

        final LinkedList<FlightConnection> finalConnectionList = flightsConnection.stream()
                .filter(f -> departureCity.equals(f.getDepartureCity()))
                .collect(Collector.of(
                        LinkedList<FlightConnection>::new,
                        (list, departure) -> addToResult(flightsConnection, departure, list),
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }
                ));

        System.out.println("\nCONNECTION WITH 1 STOP BETWEEN: " + departureCity + " AND " + arrivalCity);
        finalConnectionList.forEach(System.out::println);
        return finalConnectionList;
    }

    private void addToResult(List<Flight> flightsConnection, Flight departure, List<FlightConnection> result) {
        flightsConnection.stream()
                .filter(f -> departure.getArrivalCity().equals(f.getDepartureCity()))
                .filter(f -> departure.getArrivalTime().isBefore(f.getDepartureTime().minusHours(1)))
                .forEach(arrival -> result.add(new FlightConnection(departure, arrival)));
    }
}
