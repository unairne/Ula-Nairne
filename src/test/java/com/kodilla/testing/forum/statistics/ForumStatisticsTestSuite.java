package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistics.Statistics;
import com.kodilla.testing.forum.statistics.StatisticsCheck;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    public ArrayList<String> sampleUsers(int numberOfUsers) {
        String user = "User ";
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            users.add(user + i);
        }
        return users;
    }

    @Test
    public void testPostAmount0() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCheck statisticsCheck = new StatisticsCheck();
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.usersNames()).thenReturn(sampleUsers(10));

        //When
        statisticsCheck.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, statisticsCheck.getPostsAmount(), 0);
        Assert.assertEquals(10, statisticsCheck.getCommentsAmount(), 0);
        Assert.assertEquals(10, statisticsCheck.getUsersAmount(), 0);
        Assert.assertEquals(0, statisticsCheck.getPostsPerUser(), 0);
        Assert.assertEquals(1, statisticsCheck.getCommentsPerUser(), 0);
        Assert.assertEquals(0, statisticsCheck.getCommentsPerPost(), 0);

    }

    @Test
    public void testPostAmount1000() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCheck statisticsCheck = new StatisticsCheck();


        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10000);
        when(statisticsMock.usersNames()).thenReturn(sampleUsers(100));

        //When
        statisticsCheck.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(1000, statisticsCheck.getPostsAmount(), 0);
        Assert.assertEquals(10000, statisticsCheck.getCommentsAmount(), 0);
        Assert.assertEquals(100, statisticsCheck.getUsersAmount(), 0);
        Assert.assertEquals(10, statisticsCheck.getPostsPerUser(), 0);
        Assert.assertEquals(100, statisticsCheck.getCommentsPerUser(), 0);
        Assert.assertEquals(10, statisticsCheck.getCommentsPerPost(), 0);
    }

    @Test
    public void testCommentsAmount0() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCheck statisticsCheck = new StatisticsCheck();
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(sampleUsers(50));

        //When
        statisticsCheck.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, statisticsCheck.getPostsAmount(), 0);
        Assert.assertEquals(0, statisticsCheck.getCommentsAmount(), 0);
        Assert.assertEquals(50, statisticsCheck.getUsersAmount(), 0);
        Assert.assertEquals(2, statisticsCheck.getPostsPerUser(), 0);
        Assert.assertEquals(0, statisticsCheck.getCommentsPerUser(), 0);
        Assert.assertEquals(0, statisticsCheck.getCommentsPerPost(), 0);
    }

    @Test
    public void testCommentsLessThanPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCheck statisticsCheck = new StatisticsCheck();

        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.usersNames()).thenReturn(sampleUsers(50));

        //When
        statisticsCheck.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, statisticsCheck.getPostsAmount(), 0);
        Assert.assertEquals(50, statisticsCheck.getCommentsAmount(), 0);
        Assert.assertEquals(50, statisticsCheck.getUsersAmount(), 0);
        Assert.assertEquals(2, statisticsCheck.getPostsPerUser(), 0.0);
        Assert.assertEquals(1, statisticsCheck.getCommentsPerUser(), 0.0);
        Assert.assertEquals(0.5, statisticsCheck.getCommentsPerPost(), 0.0);
    }

    @Test
    public void testCommentsMoreThanPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCheck statisticsCheck = new StatisticsCheck();
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(sampleUsers(50));

        //When
        statisticsCheck.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(50, statisticsCheck.getPostsAmount(), 0);
        Assert.assertEquals(100, statisticsCheck.getCommentsAmount(), 0);
        Assert.assertEquals(50, statisticsCheck.getUsersAmount(), 0);
        Assert.assertEquals(1, statisticsCheck.getPostsPerUser(), 0.0);
        Assert.assertEquals(2, statisticsCheck.getCommentsPerUser(), 0.0);
        Assert.assertEquals(2, statisticsCheck.getCommentsPerPost(), 0.0);
    }

    @Test
    public void testUserAmount0() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCheck statisticsCheck = new StatisticsCheck();
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(sampleUsers(0));

        //When
        statisticsCheck.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, statisticsCheck.getPostsAmount(), 0);
        Assert.assertEquals(100, statisticsCheck.getCommentsAmount(), 0);
        Assert.assertEquals(0, statisticsCheck.getUsersAmount(), 0);
        Assert.assertEquals(0, statisticsCheck.getPostsPerUser(), 0.0);
        Assert.assertEquals(0, statisticsCheck.getCommentsPerUser(), 0.0);
        Assert.assertEquals(1, statisticsCheck.getCommentsPerPost(), 0.0);
    }

    @Test
    public void testUserAmount100() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCheck statisticsCheck = new StatisticsCheck();
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(sampleUsers(100));

        //When
        statisticsCheck.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, statisticsCheck.getPostsAmount(), 0);
        Assert.assertEquals(100, statisticsCheck.getCommentsAmount(), 0);
        Assert.assertEquals(100, statisticsCheck.getUsersAmount(), 0);
        Assert.assertEquals(1, statisticsCheck.getPostsPerUser(), 0.0);
        Assert.assertEquals(1, statisticsCheck.getCommentsPerUser(), 0.0);
        Assert.assertEquals(1, statisticsCheck.getCommentsPerPost(), 0.0);
    }

}