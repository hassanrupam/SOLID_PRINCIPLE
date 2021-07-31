package com.hassan.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Purpose of this class is to show the solution of the violation of Liskov-Substitution Principal we saw in the
 * LSP_Violation project
 * <p>
 * The Liskov-Substitution Principle states that "Child classes should never break the parent class type definitions".
 * To simplify we can say, the opposite as - We should not put any behaviour or property in a parent which is not
 * utilized by all the child classes. All the common things, either attributes/properties or any behaviours for all
 * the child should only be described in parent. So that Each child would be substitutable of the parent class.
 * </p>
 * <p>
 * As we have removes the _security_code (String) attribute from the behaviour processPayment(..) from the parent
 * now we have to remove this from our child classes too. Here We removed the parameter from the method but we need the
 * cardNumber attribute which we used inside the processPayment(..) in our LSP_Violation with the _security_code (String).
 * As the cardNumber attribute is only needed for CardPaymentProcessor class so we define it here and not is the
 * parent as it is not a common attribute. This Satisfies the Liskov-Substitute Principle.
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
