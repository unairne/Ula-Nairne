package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskFactoryTestSuite {

    private TaskFactory taskFactory;

    @Before
    public void beforeTest() {
        taskFactory = new TaskFactory();
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        //When
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVING_TASK);
        //Then
        drivingTask.executeTask();
        Assert.assertEquals("Deliver the car", drivingTask.getTaskName());
        Assert.assertTrue(drivingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        //When
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTING_TASK);
        //Then
        paintingTask.executeTask();
        Assert.assertEquals("Paint the body", paintingTask.getTaskName());
        Assert.assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryShoppingTask() {
        //Given
        //When
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPING_TASK);
        //Then
        shoppingTask.executeTask();
        Assert.assertEquals("Buy new mirror", shoppingTask.getTaskName());
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryAnotherTask() {
        //Given
        //When
        Task anotherTask = taskFactory.createTask("TEST");
        //Then
        Assert.assertNull(anotherTask);
    }
}
