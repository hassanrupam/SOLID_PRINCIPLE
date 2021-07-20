package com.hassan.core;

/**
 * The Purpose of this class is to show the solution of Single Responsibility Principal
 * of the violation that we saw in the previous project named SRP_Violation
 * <p>
 * As per the Single Responsibility Principal, It states that -> A class should have one, and only one, reason to change.
 * <p>
 * So to remove those unrelated functionality of Order class , We created this class "PaymentProcessor"
 * which  has the responsibility of
 * Process Payments                     -> void processPayment(String _type, String _security_code)
 * and Checking if Payment is Done      -> public void isPaid()
 * <p>
 * Created by Hassan Sakib Afrin on 20-07-2021
 */
public class PaymentProcessor {
    //region PUBLIC METHODS
    public void processPayment(String _type, Order _order, String _security_code) {
        if (_type.equals("CARD")) {
            System.out.println("Processing Card Payment");
            System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
            _order.setPaid(true);
        } else if (_type.equals("ONLINE")) {
            System.out.println("Processing Online Payment");
            System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
            _order.setPaid(true);
        } else {
            System.out.println("Unknown Payment Type");
        }
    }

    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
    //endregion
}
