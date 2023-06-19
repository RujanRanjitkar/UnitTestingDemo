package org.example;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing BankLoanService class")
//@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class) // best we should add @Order(n) on top of test methods while using this option
//    @TestMethodOrder(value = MethodOrderer.MethodName.class) // takes ascii value
//    @TestMethodOrder(value = MethodOrderer.DisplayName.class) // takes ascii value
    @TestMethodOrder(value = MethodOrderer.Random.class) //default
class BankLoanServiceTest {
    private static BankLoanService service;
//    @BeforeEach
//    public void setUp(){
//        service=new BankLoanService();
//    }

    @BeforeAll
    public static void setUpOnce(){
        service=new BankLoanService();
    }
    @Test
//    @Order(1)
    @DisplayName("Testing with small number")
    @Tag("dev")
    public void testcalcSimpleInterestAmountWithSmallNumber(){

        float actual=service.calcSimpleInterestAmount(100000,2,12);
        float expected=24000.12f;
        assertEquals(expected,actual, 0.5, "May be results is not matching");
        //0.5 is delta value-> the difference that is allowed in result
    }

    @Test
//    @Order(2)
    @DisplayName("Testing with big number")
    @Tag("dev")
    public void testcalcSimpleInterestAmountWithBigNumber(){

//        float actual=service.calcSimpleInterestAmount(10000000,2,12);
//        float expected=24000000;
//        assertEquals(expected,actual);
        assertEquals(2400000.0f, service.calcSimpleInterestAmount(10000000,2,12), "May be results is not matching");
    }

    @Test
//    @Order(3)
    @DisplayName("Testing with invalid inputs")
    @Tag("uat")
    @Tag("dev")
    public void testcalcSimpleInterestAmountWithInvalidInputs(TestInfo info){
        System.out.println(info.getClass() + " " + info.getTags() + " " + info.getDisplayName() + " " + info.getTestClass() + " " + info.getTestMethod());
        assertThrows(IllegalArgumentException.class,
                ()-> service.calcSimpleInterestAmount(0,0,0),
                "May be exception raised is not matching"
                );
    }

    @Test
//    @Order(-10)
    @DisplayName("Testing with timer")
    @Tag("uat")
    @Disabled // to disable method
    public void testcalcSimpleInterestAmountWithTimer(){

        assertTimeout(Duration.ofMillis(20000),
                ()-> service.calcSimpleInterestAmount(10000000,2,12)
        );
    }

    @Test
//    @Order(10)
    @DisplayName("Testing for no exception")
    @Tag("test")
    public void testcalcSimpleInterestAmountForNoException(){

        assertDoesNotThrow(
                ()-> service.calcSimpleInterestAmount(10000,2,12)
        );
    }

//    @AfterEach
//    public void clear(){
//        service=null;
//    }

    @AfterAll
    public static void clearOnce(){
        service=null;
    }
}