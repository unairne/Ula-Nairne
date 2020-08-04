package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        List<String> toDoList = board.getToDoList().getTasks();
        List<String> doneList = board.getDoneList().getTasks();
        List<String> inProgressList = board.getInProgressList().getTasks();
        doneList.add("Software upgrade");
        inProgressList.add("Upgrade interface");
        toDoList.add("Send application to client");
        //Then
        System.out.println(doneList.get(0) + "\n" + inProgressList.get(0) + "\n" + toDoList.get(0));
        Assert.assertEquals(1,toDoList.size());
        Assert.assertEquals("Upgrade interface",inProgressList.get(0));
        Assert.assertEquals("Software upgrade",doneList.get(0));

    }
}