package com.kodilla.patterns.strategy.social;

public class User {

    private final String userName;
    protected SocialPublisher socialPublisher;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String showSocial() {
        return socialPublisher.share();
    }

    public String sharePost(String post) {
        return userName + ": " + post;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
