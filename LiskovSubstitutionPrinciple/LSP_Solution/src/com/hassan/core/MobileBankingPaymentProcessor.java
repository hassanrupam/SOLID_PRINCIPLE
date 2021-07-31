package com.hassan.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * cellNumber attribute which we used inside the processPayment(..) in our LSP_Violation with the _security_code (String).
 * As the cellNumber attribute is only needed for MobileBankingPaymentProcessor class so we define it here and not is the
 * parent as it is not a common attribute. This Satisfies the Liskov-Substitute Principle.
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
    //endregion


    //region PRIVATE FIELDS
    private Boolean isValidCellNumber(String _cellNumber){
        Matcher cellMatcher = cellPattern.matcher(_cellNumber);
        return cellMatcher.matches();
    }
    //endregion
}
