package com.hassan.core;

public class Main {

    public static void main(String[] args) {

        PaymentProcessor paymentProcessor =  new PaymentProcessor();

        Order firstOrder =  new Order("ORD-001");
        firstOrder.add_Item("Keyboard",5.0,300.0);
        firstOrder.add_Item("Mouse",2.0,250.0);
        firstOrder.add_Item("Webcam",1.0,2000.0);

        System.out.println("Total Price : " + firstOrder.totalPrice());
        paymentProcessor.isPaid(firstOrder);
        paymentProcessor.processPayment("CARD",firstOrder,"1565");
        paymentProcessor.isPaid(firstOrder);

        System.out.println();

        Order secondOrder =  new Order("ORD-002");
        secondOrder.add_Item("T-Shirt",2.0,950.0);
        secondOrder.add_Item("Trousers",1.0,1150.0);

        System.out.println("Total Price : " + secondOrder.totalPrice());
        paymentProcessor.isPaid(secondOrder);
        paymentProcessor.processPayment("CARD",secondOrder,"1565");
        paymentProcessor.isPaid(secondOrder);
    }
}
