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
 * emailAddress attribute which we used inside the processPayment(..) in our LSP_Violation with the _security_code (String).
 * As the emailAddress attribute is only needed for CryptoCurrencyPaymentProcessor class so we define it here and not is the
 * parent as it is not a common attribute. This Satisfies the Liskov-Substitute Principle.
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
    //endregion


    //region PRIVATE FIELDS
    private Boolean isValidEmail(String _emailAddress){
        Matcher emailMatcher = emailPattern.matcher(_emailAddress);
        return emailMatcher.matches();
    }
    //endregion
}
