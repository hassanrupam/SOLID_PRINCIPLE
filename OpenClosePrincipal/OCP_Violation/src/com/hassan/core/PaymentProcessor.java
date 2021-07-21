package com.hassan.core;

/**
 * The Purpose of this class is to show the violation of Open-Close Principal
 *
 * <p>
 * From the previous Solution of Single Responsibility Principal, we had separated the Payment Processing Functionality
 * to a new Class. We can see that on the Project  "SRP_Solution". There we can see that our Payment processor could
 * process CARD and ONLINE payments in the processPayment(..) Method.
 * </p>
 * <p>
 * But now , a new Request for change came which specifies to add CryptoCurrency and Mobile Banking Payments in the
 * Payments Processor.
 * </p>
 * <p>
 * So if we think generally, we would implement the new requirement that came in the same method. As we can see we had
 * been keeping the processPayment(..) Method very simple which takes the Type as argument and processes Accordingly
 * with a nested if else section. That's What we did here, We added two nested if else section which can now process
 * Crypto Currency and Mobile Banking Payments.
 * </p>
 * Created by Hassan Sakib Afrin on 20-07-2021
 */
public class PaymentProcessor {
    //region PUBLIC METHODS
    public void processPayment(String _type, Order _order, String _security_code) {
        if (_type.equals("CARD")) {
            System.out.println("Processing Card Payment");
            System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
            _order.setPaid(true);
        } else if (_type.equals("ONLINE")) {
            System.out.println("Processing Online Payment");
            System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
            _order.setPaid(true);
        } else if (_type.equals("CRYPTO")) {
            System.out.println("Processing Crypto Currency Payment");
            System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
            _order.setPaid(true);
        } else if (_type.equals("MOBILE")) {
            System.out.println("Processing Mobile Banking Payment");
            System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
            _order.setPaid(true);
        } else {
            System.out.println("Unknown Payment Type");
        }
    }

    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
    //endregion
}
