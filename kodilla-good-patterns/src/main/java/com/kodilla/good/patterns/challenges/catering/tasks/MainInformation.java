package com.kodilla.good.patterns.challenges.catering.tasks;

import com.kodilla.good.patterns.challenges.catering.tasks.InformationService;

public class MainInformation implements InformationService {

    @Override
    public void inform() {
        System.out.println("Order has been confirmed! \n");
    }
}
