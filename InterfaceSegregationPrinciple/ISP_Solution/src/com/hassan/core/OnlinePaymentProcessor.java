package com.hassan.core;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * The Purpose of this class is to show the solution for the violation of Interface Segregation Principle
 * we saw in ISP_Violation project.
 *
 * The class now implements ITwoFactorAuth and IPaymentProcessor and defines the methods with own behaviour
 *
 * Created by Hassan Sakib Afrin on 31-07-2021
 */
public class OnlinePaymentProcessor implements IPaymentProcessor,ITwoFactorAuth{

    //region PRIVATE FIELDS
    private String securityCode;
    //endregion

    //region CONSTRUCTORS
    public OnlinePaymentProcessor(String _securityCode) {
        this.securityCode = _securityCode;
    }
    //endregion

    //region PUBLIC METHODS
    @Override
    public void processPayment(Order _order) {
        try {
            verifyTwoFactorAuth();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Processing Online Payment");
        System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + this.securityCode);
        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }

    @Override
    public void verifyTwoFactorAuth() throws Exception {
        System.out.println("Verifying Two Factor Authentication");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Verification Complete");
    }
    //endregion
}
