package com.hassan.core;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    //region PRIVATE FIELDS
    private final Order testOrder =  new Order("Test-Order-01");
    private final PrintStream original =  System.out;
    private final ByteArrayOutputStream byteArrayOutputStream =  new ByteArrayOutputStream();
    private final PrintStream pst = new PrintStream(byteArrayOutputStream);
    //endregion

    @Test
    void add_Item() {
        assertEquals(0,testOrder.itemList.size());
        testOrder.add_Item("Test Object",1.0,1.0);
        assertEquals(1,testOrder.itemList.size());
    }

    @Test
    void totalPrice() {
        assertEquals(0.0,testOrder.totalPrice());
        testOrder.add_Item("Test Object",1.0,1.0);
        assertEquals(1.0,testOrder.totalPrice());
        testOrder.add_Item("Test Object-02",5.0,2.0);
        assertEquals(11.0,testOrder.totalPrice());
    }

    @Test
    void processPayment() {
        System.setOut(pst);
        testOrder.processPayment("Something","45654");
        System.setOut(original);
        pst.flush();
        assertEquals("Unknown Payment Type",byteArrayOutputStream.toString().trim());
    }

    @Test
    void isPaid() {
        System.setOut(pst);
        testOrder.isPaid();
        System.setOut(original);
        pst.flush();
        assertEquals("Payment is Pending",byteArrayOutputStream.toString().trim());
    }
}