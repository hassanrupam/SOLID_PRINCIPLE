package com.hassan.core;

/**
 * The Mobile Banking  Payment processor can hold it's own definition of processPayment(..) method to satisfy the
 * Open-Close Principal.
 * But to demonstrate the violation of Liskov-Substitution Principle, If we see the other Payment processor, we
 * have seen so far that each of them use the _security_code (String) differently. But in Online Payment Processing
 * we use this the actual intention of the _security_code parameter.
 *
 * Created by Hassan Sakib Afrin on 21-07-2021
 */
public class OnlinePaymentProcessor implements IPaymentProcessor{
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Online Payment");
        System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
}
