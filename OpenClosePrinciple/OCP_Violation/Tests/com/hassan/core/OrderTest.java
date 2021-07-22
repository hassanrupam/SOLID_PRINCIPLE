package com.hassan.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    //region PRIVATE FIELDS
    private final Order testOrder =  new Order("Test-Order-01");
    //endregion

    //region TEST METHODS
    @Test
    void getOrderNumber() {
        assertEquals("Test-Order-01",testOrder.getOrderNumber());
    }

    @Test
    void getPaid() {
        assertEquals(false,testOrder.getPaid());
    }

    @Test
    void setPaid() {
        testOrder.setPaid(true);
        assertEquals(true,testOrder.getPaid());
    }

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
    //endregion
}