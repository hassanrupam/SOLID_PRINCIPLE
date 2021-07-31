package com.hassan.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Crypto Currency Payment processor can hold it's own definition of processPayment(..) method to satisfy the
 * Open-Close Principal.
 * But now to demonstrate The Liskov-Substitution Principle, Let's take a look into the processPayment(..) method,
 * where the parameters are _order (Order) and _security_code (String). As the Interface IPaymentProcessor contains the
 * processPayment(..) method signature with these two parameter. But for the CryptoPayment Process let's assume we
 * won't need the Security Code, instead we need an email address. But as we can use the _security_code (String)
 * to disguise as an Email Address without changing any structure of the Code and it will be fuly functional, we might
 * think it's a good idea. But in our case this may reduce the code readability and confusion may arise very easily.
 *
 * Created by Hassan Sakib Afrin on 31-07-2021
 */
public class CryptoCurrencyPaymentProcessor implements IPaymentProcessor{

    //region PRIVATE FIELDS
    private String emailAddress;
    private final Pattern emailPattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}");
    //endregion

    //region PUBLIC METHODS
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Crypto Currency Payment");
        if(isValidEmail(_security_code)){
            System.out.println("One Time Validation code for order : " + _order.getOrderNumber() + " is sent to Email : " + _security_code);
        }else{
            System.out.println("Invalid Email Address");
        }

        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
    //endregion

    //region PRIVATE FIELDS
    private Boolean isValidEmail(String _emailAddress){
        Matcher emailMatcher = emailPattern.matcher(_emailAddress);
        return emailMatcher.matches();
    }
    //endregion
}
