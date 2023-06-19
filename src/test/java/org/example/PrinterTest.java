package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {

    @Test
    public void singletonTest() {
        Printer p1=Printer.getInstance();
        Printer p2=Printer.getInstance();
//        assertNotNull(p1);
//        assertNotNull(p2);
        if(p1==null || p2==null)
            fail("p1,p2 references must not be null");
        assertSame(p1,p2);
    }
}