package com.kodilla.patterns.singleton;

import com.kodilla.patterns.singleton.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void testLog() { Logger.getInstance().log("firstLog.log"); }

    @Test
    public void testGetLastLog() {
        //Given
        //When
        String log = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("firstLog.log", log);
    }
}