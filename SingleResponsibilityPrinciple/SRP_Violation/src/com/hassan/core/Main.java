package com.hassan.core;

public class Main {

    public static void main(String[] args) {
        Order firstOrder =  new Order("ORD-001");
        firstOrder.add_Item("Keyboard",5.0,300.0);
        firstOrder.add_Item("Mouse",2.0,250.0);
        firstOrder.add_Item("Webcam",1.0,2000.0);

        System.out.println("Total Price : " + firstOrder.totalPrice());
        firstOrder.isPaid();
        firstOrder.processPayment("CARD","1565");
        firstOrder.isPaid();
        System.out.println();
        Order secondOrder =  new Order("ORD-002");
        secondOrder.add_Item("T-Shirt",2.0,950.0);
        secondOrder.add_Item("Trousers",1.0,1150.0);

        System.out.println("Total Price : " + secondOrder.totalPrice());
        secondOrder.isPaid();
        secondOrder.processPayment("ONLINE","4468");
        secondOrder.isPaid();
    }
}
