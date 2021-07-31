package com.hassan.core;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
public class CardPaymentProcessor implements IPaymentProcessor{

    //region PRIVATE FIELDS
    private String cardNumber;
    private final String visaCardPrefix="4";
    //endregion

    //region CONSTRUCTORS
    public CardPaymentProcessor(String _cardNumber) {
        this.cardNumber = _cardNumber;
    }
    //endregion

    //region PUBLIC METHODS
    @Override
    public void processPayment(Order _order) {
        System.out.println("Processing Card Payment");
        if(isValidCardNumber(this.cardNumber)){
            System.out.println("Payment Done From Card : "+ this.cardNumber +" for order : " + _order.getOrderNumber());
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

    @Override
    public void verifyTwoFactorAuth() throws Exception {
       throw new Exception("Card Payment doesn't support two factor authentication!");
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
