package com.hassan.core;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * The Purpose of this class is to show the violation of Interface Segregation Principle
 * <p>
 * We assume we have Two Factor Authentication support for Mobile Banking, so we implemented the method
 * verifyTwoFactorAuth() here properly. In general we would have written all sort of verification process
 * and sub routines here but for sake of simplicity we kept it simple just by some hard coded text to just
 * show the concept of Interface Segregation Principle.
 *
 * </p>
 *
 * Created by Hassan Sakib Afrin on 31-07-2021
 */
public class OnlinePaymentProcessor implements IPaymentProcessor{

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
