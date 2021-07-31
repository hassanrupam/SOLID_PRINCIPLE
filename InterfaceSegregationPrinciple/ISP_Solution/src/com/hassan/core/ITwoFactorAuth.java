package com.hassan.core;


/**
 * The Purpose of this interface is to show the solution of the violation of Interface Segregation Principle we saw in the
 * ISP_Violation project
 * <p>
 *  The method verifyTwoFactorAuth() now is in ITwoFactorAuth interface. As we have seen two classes supports the
 *  behaviour of two factor authentication which are MobileBankingPaymentProcessor and OnlinePaymentProcessor.
 *  So now, we can just Implement the ITwoFactorAuth interface along with IPaymentProcessor interface to only those
 *  two class and implement the methods with their own behavioural definition.
 *
 *  And the Other two class  CardPaymentProcessor and CryptoCurrencyPaymentProcessor can only implement IPaymentProcessor
 *  as they don;t support Two Factor Authentication. This now satisfies Interface Segregation Principle.
 * </p>
 * Created by Hassan Sakib Afrin on 31-07-2021
 */
public interface ITwoFactorAuth {
    public void verifyTwoFactorAuth() throws Exception;
}
