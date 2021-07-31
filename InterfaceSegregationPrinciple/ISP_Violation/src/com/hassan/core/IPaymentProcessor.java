package com.hassan.core;

/**
 * The Purpose of this class is to show the violation of Interface Segregation Principle
 * <p>
 *  The Interface Segregation Principle states that  "No client should be forced to depend on methods it does not use."
 *  To demonstrate the violation of this principle, let's assume we need Two Factor Authorization for our
 *  payment processing. So we introduce a new behaviour (method) in out interface verifyTwoFactorAuth() which will
 *  be implemented according to the each child class with their own definition for two factor verification.
 * </p>
 *
 * Created by Hassan Sakib Afrin on 31-07-2021
 */
public interface IPaymentProcessor {
    public void processPayment(Order _order);
    public void isPaid(Order _order);
    public void verifyTwoFactorAuth() throws Exception;
}
