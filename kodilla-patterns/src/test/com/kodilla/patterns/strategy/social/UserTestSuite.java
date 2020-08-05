package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User firstUser = new Millenials("firstUser");
        User secondUser = new YGeneration("secondUser");
        User thirdUser = new ZGeneration("thirdUser");
        //When
        String firstUserSocialAccount = firstUser.showSocial();
        System.out.println(firstUserSocialAccount + firstUser.getUserName());
        String firstUserComment = firstUser.sharePost("Twitter is better than Facebook!");
        System.out.println(firstUserComment);

        String secondUserSocialAccount = secondUser.showSocial();
        System.out.println(secondUserSocialAccount + secondUser.getUserName());
        String secondUserComment = secondUser.sharePost("Snapchat is the best!");
        System.out.println(secondUserComment);

        String thirdUserSocialAccount = thirdUser.showSocial();
        System.out.println(thirdUserSocialAccount + thirdUser.getUserName());
        String thirdUserComment = thirdUser.sharePost("Facebook is better than Twitter!");
        System.out.println(thirdUserComment);
        //Then
        Assert.assertEquals("[Twitter User] ", firstUserSocialAccount);
        Assert.assertEquals("[Snapchat User] ", secondUserSocialAccount);
        Assert.assertEquals("[Facebook User] ", thirdUserSocialAccount);
        Assert.assertEquals("firstUser: Twitter is better than Facebook!", firstUserComment);
        Assert.assertEquals("secondUser: Snapchat is the best!", secondUserComment);
        Assert.assertEquals("thirdUser: Facebook is better than Twitter!", thirdUserComment);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User firstUser = new Millenials("firstUser");
        User secondUser = new YGeneration("secondUser");
        User thirdUser = new ZGeneration("thirdUser");
        //When
        String firstUserSocialAccount = firstUser.showSocial();
        System.out.println("firstUser is: " + firstUserSocialAccount);
        firstUser.setSocialPublisher(new SnapchatPublisher());
        firstUserSocialAccount = firstUser.showSocial();
        System.out.println("Now firstUser is: " + firstUserSocialAccount);

        String secondUserSocialAccount = secondUser.showSocial();
        System.out.println("secondUser is: " + secondUserSocialAccount);
        secondUser.setSocialPublisher(new FacebookPublisher());
        secondUserSocialAccount = secondUser.showSocial();
        System.out.println("Now secondUser is: " + secondUserSocialAccount);

        String thirdUserSocialAccount = thirdUser.showSocial();
        System.out.println("firstUser is: " + thirdUserSocialAccount);
        thirdUser.setSocialPublisher(new TwitterPublisher());
        thirdUserSocialAccount = thirdUser.showSocial();
        System.out.println("Now firstUser is: " + thirdUserSocialAccount);
        //Then
        Assert.assertEquals("[Snapchat User] ", firstUserSocialAccount);
        Assert.assertEquals("[Facebook User] ", secondUserSocialAccount);
        Assert.assertEquals("[Twitter User] ", thirdUserSocialAccount);
    }
}