package com.kodilla.good.patterns.challenges;

public class MovieStoreMain {
    public static void main(String[] args) {
        MovieStore theMovieStore= new MovieStore();
        theMovieStore.getMovies().entrySet().stream()
                .flatMap(p -> p.getValue().stream())
                .map(key -> key + "!" ).forEach(System.out::print);
    }
}