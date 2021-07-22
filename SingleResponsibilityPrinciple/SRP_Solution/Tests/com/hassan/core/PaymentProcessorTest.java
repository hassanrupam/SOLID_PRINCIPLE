package com.hassan.core;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {

    //region PRIVATE FIELDS
    private final PaymentProcessor paymentProcessor = new PaymentProcessor();
    private final Order testOrder = new Order("Test Order-01");
    private final PrintStream original =  System.out;
    private final ByteArrayOutputStream byteArrayOutputStream =  new ByteArrayOutputStream();
    private final PrintStream pst = new PrintStream(byteArrayOutputStream);
    //endregion

    //region TEST METHODS
    @Test
    void processPayment() {
        System.setOut(pst);
        paymentProcessor.processPayment("Something",testOrder,"45654");
        System.setOut(original);
        pst.flush();
        assertEquals("Unknown Payment Type",byteArrayOutputStream.toString().trim());
    }

    @Test
    void isPaid() {
        System.setOut(pst);
        paymentProcessor.isPaid(testOrder);
        System.setOut(original);
        pst.flush();
        assertEquals("Payment is Pending",byteArrayOutputStream.toString().trim());
    }
    //endregion
}