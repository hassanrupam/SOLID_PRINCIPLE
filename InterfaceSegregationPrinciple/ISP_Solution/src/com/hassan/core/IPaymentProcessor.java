package com.hassan.core;

/**
 * The Purpose of this interface is to show the solution of the violation of Interface Segregation Principle we saw in the
 * ISP_Violation project
 * <p>
 *  The Interface Segregation Principle states that  "No client should be forced to depend on methods it does not use."
 *  To accumulate the Two factor authentication we had given the verifyTwoFactorAuth() method in IPaymentProcessor
 *  which was then implemented by all the 4 Payment Processor classes. But we also had seen that the CardPaymentProcessor
 *  and CryptoCurrencyPaymentProcessor didn't have any support for Two Factor Authentication for which we had only raised
 *  Exception in their definitions. But this violates the Interface Segregation Principle. So, we removed the signature
 *  from the IPaymentProcessor and Created a separate interface named ITwoFactorAuth containing the verifyTwoFactorAuth()
 *  method.
 * </p>
 *
 * Created by Hassan Sakib Afrin on 31-07-2021
 */
public interface IPaymentProcessor {
    public void processPayment(Order _order);
    public void isPaid(Order _order);
}
