package com.kodilla.testing.forum.statistics;

public class StatisticsCheck {

    private double usersAmount;
    private double postsAmount;
    private double commentsAmount;
    private double postsPerUser;
    private double commentsPerUser;
    private double commentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {

        usersAmount = statistics.usersNames().size();
        postsAmount = statistics.postsCount();
        commentsAmount = statistics.commentsCount();


        if (!statistics.usersNames().isEmpty() && statistics.postsCount() != 0) {
            postsPerUser = postsAmount / usersAmount;
        } else {
            postsPerUser = 0.0;
        }
        if (!statistics.usersNames().isEmpty() && statistics.commentsCount() != 0) {
            commentsPerUser = commentsAmount / usersAmount;
        } else {
            commentsPerUser = 0.0;
        }
        if (statistics.commentsCount() != 0 && statistics.postsCount() != 0) {
            commentsPerPost = commentsAmount / postsAmount;
        } else {
            commentsPerPost = 0.0;
        }
    }

    public double getUsersAmount() {
        return usersAmount;
    }

    public double getPostsAmount() {
        return postsAmount;
    }

    public double getCommentsAmount() {
        return commentsAmount;
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }

    public void showStatistic() {
        System.out.println("Users on forum: " + usersAmount);
        System.out.println("Total posts on forum: " + postsAmount);
        System.out.println("Total comments on forum: " + commentsAmount);
        System.out.println("Posts per User: " + postsPerUser);
        System.out.println("Comments per User:" + commentsPerUser);
        System.out.println("Comments per Post: " + commentsPerPost);

    }
}