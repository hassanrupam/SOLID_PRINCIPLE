package com.hassan.core;
/**
 * The Crypto Currency Payment processor can hold it's own definition of processPayment(..) method. So it is easier to maintain
 * and is closed for minimum modification if any future change occurs in any requirements. But as IPaymentProcessor
 * is just the signature of how a Payment Process should be, so we are open to any new Payment Processor
 * that might come in future
 *
 * Created by Hassan Sakib Afrin on 21-07-2021
 */
public class CryptoCurrencyPaymentProcessor implements IPaymentProcessor{
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Crypto Currency Payment");
        System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
}
