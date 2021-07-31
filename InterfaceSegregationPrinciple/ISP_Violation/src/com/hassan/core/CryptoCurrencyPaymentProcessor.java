package com.hassan.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Purpose of this class is to show the violation of Interface Segregation Principle
 * <p>
 * As te Parent Interface has a new method verifyTwoFactorAuth() now, we implemented it.
 * But assume we don't have any two factor authentication for VISA cards so we just raised an Exception
 * that it is not supported yet
 * </p>
 *
 * Created by Hassan Sakib Afrin on 31-07-2021
 */
public class CryptoCurrencyPaymentProcessor implements IPaymentProcessor{

    //region PRIVATE FIELDS
    private String emailAddress;
    private final Pattern emailPattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}");
    //endregion

    //region CONSTRUCTORS
    public CryptoCurrencyPaymentProcessor(String _emailAddress) {
        this.emailAddress = _emailAddress;
    }
    //endregion

    //region PUBLIC METHODS
    @Override
    public void processPayment(Order _order) {
        System.out.println("Processing Crypto Currency Payment");
        if (isValidEmail(this.emailAddress)) {
            System.out.println("One Time Validation code for order : " + _order.getOrderNumber() + " is sent to Email : " + this.emailAddress);
        } else {
            System.out.println("Invalid Email Address");
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
        throw new Exception("Card Payment doesn't support two factor authentication!");
    }
    //endregion


    //region PRIVATE FIELDS
    private Boolean isValidEmail(String _emailAddress){
        Matcher emailMatcher = emailPattern.matcher(_emailAddress);
        return emailMatcher.matches();
    }
    //endregion
}
