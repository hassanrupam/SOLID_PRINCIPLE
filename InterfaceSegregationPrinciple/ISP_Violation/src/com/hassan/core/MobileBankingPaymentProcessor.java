package com.hassan.core;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
public class MobileBankingPaymentProcessor implements IPaymentProcessor{

    //region PRIVATE FIELDS
    private String cellNumber;
    private final Pattern cellPattern = Pattern.compile("^(?:\\+?88)?01[13-9]\\d{8}$");
    //endregion

    //region Constructors
    public MobileBankingPaymentProcessor(String cellNumber) {
        this.cellNumber = cellNumber;
    }
    //endregion

    //region PUBLIC METHODS
    @Override
    public void processPayment(Order _order) {
        System.out.println("Processing Mobile Banking Payment");
        if(isValidCellNumber(this.cellNumber)){
            try {
                verifyTwoFactorAuth();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            System.out.println("OTP sent for : " + _order.getOrderNumber() + " to Cell Number : " + this.cellNumber);
        }else{
            System.out.println("Invalid Cell Number");
        }
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

    //region PRIVATE FIELDS
    private Boolean isValidCellNumber(String _cellNumber){
        Matcher cellMatcher = cellPattern.matcher(_cellNumber);
        return cellMatcher.matches();
    }
    //endregion
}
