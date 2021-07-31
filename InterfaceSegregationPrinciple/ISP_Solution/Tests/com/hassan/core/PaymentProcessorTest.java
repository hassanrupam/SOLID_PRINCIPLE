package com.hassan.core;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentProcessorTest {

    //region PRIVATE FIELDS
    private final CardPaymentProcessor cardPaymentProcessor = new CardPaymentProcessor("XXXX-XXXX-XXXX-XXXX");
    private final OnlinePaymentProcessor onlinePaymentProcessor = new OnlinePaymentProcessor("4256");
    private final CryptoCurrencyPaymentProcessor cryptoCurrencyPaymentProcessor = new CryptoCurrencyPaymentProcessor("hassanrupam@gmail.com");
    private final MobileBankingPaymentProcessor mobileBankingPaymentProcessor = new MobileBankingPaymentProcessor("+8801700000000");
    private final Order testOrder = new Order("Test Order-01");
    private final PrintStream original =  System.out;
    private final ByteArrayOutputStream byteArrayOutputStream =  new ByteArrayOutputStream();
    private final PrintStream pst = new PrintStream(byteArrayOutputStream);
    //endregion

    //region TEST METHODS
    @Test
    void cardPaymentProcessor() {
        System.setOut(pst);
        cardPaymentProcessor.processPayment(testOrder);
        System.setOut(original);
        pst.flush();
        assertEquals("Processing Card Payment\r\nSecurity Code for order : Test Order-01 is : 45654",byteArrayOutputStream.toString().trim());
    }

    @Test
    void onlinePaymentProcessor() {
        System.setOut(pst);
        onlinePaymentProcessor.processPayment(testOrder);
        System.setOut(original);
        pst.flush();
        assertEquals("Processing Online Payment\r\nSecurity Code for order : Test Order-01 is : 45654",byteArrayOutputStream.toString().trim());
    }

    @Test
    void cryptoCurrencyPaymentProcessor() {
        System.setOut(pst);
        cryptoCurrencyPaymentProcessor.processPayment(testOrder);
        System.setOut(original);
        pst.flush();
        assertEquals("Processing Crypto Currency Payment\r\nSecurity Code for order : Test Order-01 is : 45654",byteArrayOutputStream.toString().trim());
    }

    @Test
    void mobileBankingAPaymentProcessor() {
        System.setOut(pst);
        mobileBankingPaymentProcessor.processPayment(testOrder);
        System.setOut(original);
        pst.flush();
        assertEquals("Processing Mobile Banking Payment\r\nSecurity Code for order : Test Order-01 is : 45654",byteArrayOutputStream.toString().trim());
    }

    @Test
    void isPaid() {
        System.setOut(pst);
        cardPaymentProcessor.isPaid(testOrder);
        System.setOut(original);
        pst.flush();
        assertEquals("Payment is Pending",byteArrayOutputStream.toString().trim());
    }
    //endregion
}