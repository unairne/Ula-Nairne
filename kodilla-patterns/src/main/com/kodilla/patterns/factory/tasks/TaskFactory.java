package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String PAINTING_TASK = "PAINTING TASK";
    public static final String SHOPPING_TASK = "SHOPPING TASK";
    public static final String DRIVING_TASK = "DRIVING TASK";

    public final Task createTask(final String taskType) {
        switch (taskType) {
            case PAINTING_TASK:
                return new PaintingTask("Paint the body", "Red", "Bumper");
            case SHOPPING_TASK:
                return new ShoppingTask("Buy new mirror", "Mirror", 1);
            case DRIVING_TASK:
                return new DrivingTask("Deliver the car", "Warsaw", "");
            default:
                System.out.println("Task was not created!");
                return null;
        }
    }
}
