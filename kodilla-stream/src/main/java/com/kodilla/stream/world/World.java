package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public final class World {
    private final String worldName;
    private final List<Continent> listOfContinents = new ArrayList<>();

    public World(String worldName){
        this.worldName=worldName;
    }

    public List<Continent> getListOfContinents() {
        return new ArrayList<Continent>(listOfContinents);
    }
    public void addContinent(Continent continent) {
        listOfContinents.add(continent);
    }
    @Override
    public String toString() {
        return "World: " +worldName+
                "listOfContinents=" + listOfContinents +
                '}';
    }
    public BigDecimal getPeopleQuantity() {
        BigDecimal totalQuanity = listOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(country->country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return totalQuanity;

    }
}