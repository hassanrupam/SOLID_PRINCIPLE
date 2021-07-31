package com.hassan.core;

/**
 * The Purpose of this interface is to show the solution of the violation of Liskov-Substitution Principal we saw in the
 * LSP_Violation project
 * <p>
 * The Liskov-Substitution Principle states that "Child classes should never break the parent class type definitions".
 * To simplify we can say, the opposite as - We should not put any behaviour or property in a parent which is not
 * utilized by all the child classes. All the common things, either attributes/properties or any behaviours for all
 * the child should only be described in parent. So that Each child would be substitutable of the parent class.
 * </p>
 * <p>
 * In our case we saw in the LSP_Violation that all the Payment Processors had different behaviour in terms of the
 * processPayment(..) method. We say the OnlinePaymentProcessor was utilizing _security_code(String) parameter as
 * it was intended. But CryptoCurrencyPaymentProcessor used it as email, CardPaymentProcessor used it as Card Number
 * and the MobileBankingPaymentProcessor used it as Cell Number. So it seems all the classes have different need
 * in the second parameter. This violates the Liskov-Substitution Principle as the parent defines a common attribute
 * _security_code (String) which is not common for all the classes which implements the processPayment(..) behaviour.
 * So to satisfy the Liskov-Substitution Principle we should remove this from the parent and restructure our child
 * classes accordingly.
 * </p>
 * Created by Hassan Sakib Afrin on 21-07-2021
 */
public interface IPaymentProcessor {
    public void processPayment(Order _order);
    public void isPaid(Order _order);
}
