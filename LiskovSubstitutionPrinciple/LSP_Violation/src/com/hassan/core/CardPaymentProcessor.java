package com.hassan.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Card Payment Payment processor can hold it's own definition of processPayment(..) method to satisfy the
 * Open-Close Principal.
 * But now to demonstrate the violation of Liskov-Substitution Principle, Let's take a look into the processPayment(..)
 * method, where the parameters are _order (Order) and _security_code (String). As the Interface IPaymentProcessor
 * contains the processPayment(..) method signature with these two parameter. But for the Card Payment Process let's
 * assume we won't need the Security Code, instead we need a Card Number. But as we can use the _security_code (String)
 * to disguise as an Card Number without changing any structure of the Code and it will be fully functional, we might
 * think it's a good idea. But in our case this may reduce the code readability and confusion may arise very easily.
 *
 * Created by Hassan Sakib Afrin on 31-07-2021
 */
public class CardPaymentProcessor implements IPaymentProcessor{

    //region PRIVATE FIELDS
    private final String visaCardPrefix = "4";
    //endregion

    //region PUBLIC METHODS
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Card Payment");
        if(isValidCardNumber(_security_code)){
            System.out.println("Payment Done From Card : "+ _security_code +" for order : " + _order.getOrderNumber());
        }else{
            System.out.println("The Card is not Valid");
        }

        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
    //endregion

    //region PRIVATE METHODS
    private Boolean isValidCardNumber(String _cardNumber){
        List<String> sections = Arrays.asList(_cardNumber.split("-"));

        if(sections.size()==4){
            if(sections.get(0).trim().substring(0,1).equals(visaCardPrefix)){
                List<String> verifiedSections= sections.stream().filter(eachSection-> eachSection.length()==4).collect(Collectors.toList());
                return sections.size()==verifiedSections.size();
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    //endregion
}
