package com.kodilla.good.patterns.challenges.orderservice;

public class PhoneService implements InformationService {

    @Override
    public void inform(User seller) {
        System.out.println("Sending information to dealer about purchase");
    }
}