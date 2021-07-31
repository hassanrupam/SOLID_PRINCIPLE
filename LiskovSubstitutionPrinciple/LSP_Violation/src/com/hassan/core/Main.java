package com.hassan.core;

public class Main {

    public static void main(String[] args) {
        Order firstOrder =  new Order("ORD-001");
        firstOrder.add_Item("Keyboard",5.0,300.0);
        firstOrder.add_Item("Mouse",2.0,250.0);
        firstOrder.add_Item("Webcam",1.0,2000.0);

        System.out.println("Total Price : " + firstOrder.totalPrice());
        //Initialize CryptoCurrencyPaymentProcessor
        CryptoCurrencyPaymentProcessor paymentProcessor = new CryptoCurrencyPaymentProcessor();
        paymentProcessor.isPaid(firstOrder);
        paymentProcessor.processPayment(firstOrder,"hassanrupam@gmail.com");
        paymentProcessor.isPaid(firstOrder);

        System.out.println();

        Order secondOrder =  new Order("ORD-002");
        secondOrder.add_Item("T-Shirt",2.0,950.0);
        secondOrder.add_Item("Trousers",1.0,1150.0);

        System.out.println("Total Price : " + secondOrder.totalPrice());
        MobileBankingPaymentProcessor mobileBankingPaymentProcessor =  new MobileBankingPaymentProcessor();
        mobileBankingPaymentProcessor.isPaid(secondOrder);
        mobileBankingPaymentProcessor.processPayment(secondOrder,"+8801700000000");
        mobileBankingPaymentProcessor.isPaid(secondOrder);
    }
}
