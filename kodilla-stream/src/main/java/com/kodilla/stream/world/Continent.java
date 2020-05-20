package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final String continentName;
    private final List<Country> listOfCountries = new ArrayList<Country>();

    public Continent(String continentName) {
        this.continentName=continentName;
    }
    public void adCountry(Country country){
        listOfCountries.add(country);
    }
    /*
        public void setAsia(){
            listOfCountries.add(new Country("Chiny",new BigDecimal("1347374752")));
            listOfCountries.add(new Country("Indie",new BigDecimal("1166079217")));
            listOfCountries.add(new Country("Indonezja",new BigDecimal("242968342")));
            listOfCountries.add(new Country("Pakistan",new BigDecimal("176242949")));
            listOfCountries.add(new Country("Bangladesz",new BigDecimal("162221000")));
        }
        public void setEurope(){
            listOfCountries.add(new Country("Rosja",new BigDecimal("142914136")));
            listOfCountries.add(new Country("Niemcy",new BigDecimal("81772000")));
            listOfCountries.add(new Country("Francja",new BigDecimal("66000000")));
            listOfCountries.add(new Country("Wielka Brytania",new BigDecimal("62222000")));
            listOfCountries.add(new Country("Włochy",new BigDecimal("60418711")));
        }
        public void setAmerica(){
            listOfCountries.add(new Country("Stany Zjednoczone",new BigDecimal("311280492")));
            listOfCountries.add(new Country("Brazylia",new BigDecimal("201103330")));
            listOfCountries.add(new Country("Meksyk",new BigDecimal("112336538")));
        }
     */
    public List<Country> getListOfCountries() {
        return new ArrayList<Country>(listOfCountries);
    }
    @Override
    public String toString() {
        return "Continent=" + continentName+ " details: "+
                "listOfCountries=" + listOfCountries +
                '}';
    }
}
