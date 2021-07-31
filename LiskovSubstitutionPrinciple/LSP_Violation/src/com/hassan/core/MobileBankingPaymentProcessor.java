package com.hassan.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Mobile Banking  Payment processor can hold it's own definition of processPayment(..) method to satisfy the
 * Open-Close Principal.
 * But now to demonstrate the violation of Liskov-Substitution Principle, Let's take a look into the processPayment(..)
 * method, where the parameters are _order (Order) and _security_code (String). As the Interface IPaymentProcessor
 * contains the processPayment(..) method signature with these two parameter. But for the Mobile Payment Process let's
 * assume we won't need the Security Code, instead we need an Cell Number. But as we can use the _security_code (String)
 * to disguise as an Cell Number without changing any structure of the Code and it will be fully functional, we might
 * think it's a good idea. But in our case this may reduce the code readability and confusion may arise very easily.
 *
 * Created by Hassan Sakib Afrin on 21-07-2021
 */
public class MobileBankingPaymentProcessor implements IPaymentProcessor{

    //region PRIVATE FIELDS
    private final Pattern cellPattern = Pattern.compile("^(?:\\+?88)?01[13-9]\\d{8}$");
    //endregion

    //region PUBLIC METHODS
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Mobile Banking Payment");
        if(isValidCellNumber(_security_code)){
            System.out.println("OTP sent for : " + _order.getOrderNumber() + " to Cell Number : " + _security_code);
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
    //endregion

    //region PRIVATE FIELDS
    private Boolean isValidCellNumber(String _cellNumber){
        Matcher cellMatcher = cellPattern.matcher(_cellNumber);
        return cellMatcher.matches();
    }
    //endregion
}
