package com.kodilla.stream.world;

import org.junit.*;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testGetPeopleQuantity(){
        //Given
        Continent asia = new Continent("Asia");
        asia.adCountry(new Country("Chiny",new BigDecimal("1347374752")));
        asia.adCountry(new Country("Indie",new BigDecimal("1166079217")));
        asia.adCountry(new Country("Indonezja",new BigDecimal("242968342")));
        asia.adCountry(new Country("Pakistan",new BigDecimal("176242949")));
        asia.adCountry(new Country("Bangladesz",new BigDecimal("162221000")));
        Continent europe = new Continent("Europe");
        europe.adCountry(new Country("Rosja",new BigDecimal("142914136")));
        europe.adCountry(new Country("Niemcy",new BigDecimal("81772000")));
        europe.adCountry(new Country("Francja",new BigDecimal("66000000")));
        europe.adCountry(new Country("Wielka Brytania",new BigDecimal("62222000")));
        europe.adCountry(new Country("Włochy",new BigDecimal("60418711")));
        Continent america = new Continent("America");
        america.adCountry(new Country("Stany Zjednoczone",new BigDecimal("311280492")));
        america.adCountry(new Country("Brazylia",new BigDecimal("201103330")));
        america.adCountry(new Country("Meksyk",new BigDecimal("112336538")));
        World earth = new World("Earth");
        earth.addContinent(asia);
        earth.addContinent(europe);
        earth.addContinent(america);


        //When
        BigDecimal totalQuanity = earth.getPeopleQuantity();

        //Then
        BigDecimal expectedQuanity = new BigDecimal("4132933467");
        Assert.assertEquals(expectedQuanity, totalQuanity);
    }
}