package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class CensusServiceTest {
    @RepeatedTest(value = 10, name = "execution of {displayName}-{currentRepetition}/{totalRepetitions}")
    @DisplayName("Testing data export")
    public void exportDataTest(){
        CensusService service=new CensusService();
        assertEquals("data exported", service.exportData());
    }

    @ParameterizedTest
    @ValueSource(ints={10,21,34,56})
    public void isOddTest(int n){
        CensusService service=new CensusService();
        assertTrue(service.isOdd(n));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ram","sita"})
    public void sayHelloTest(String user){
        CensusService service=new CensusService();
        assertEquals("Hello:" + user, service.sayHello(user));
    }

    @ParameterizedTest
//    @ValueSource(strings = {""," ","k"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    public void isEmptyTest(String name){
        CensusService service=new CensusService();
        assertTrue(service.isEmpty(name));
    }


}