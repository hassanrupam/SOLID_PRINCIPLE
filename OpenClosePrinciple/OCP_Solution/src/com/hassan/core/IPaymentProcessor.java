package com.hassan.core;

/**
 * The Purpose of this interface is to show the solution of the violation of Open-Close Principal we saw in the
 * OCP_Violation project
 * <p>
 * To integrate the new requirements of CryptoCurrency and Mobile Banking Payments If we keep modifying Our previous
 * PaymentProcessor Class, then It will violate the Open-Close Principal.
 * </p>
 * <p>
 * Open-Close Principal states that , Software entities (classes, modules, functions, etc.) should be open for
 * extension, but closed for modification. Which means, while developing we should always think for the future
 * extensibility. Classes , Modules or Functions, everything should be written in such a way so that it can be extended
 * without modifying the already tested ones. This ensures less cohesion on objects.
 * </p>
 * <p>
 * As per implementing the new requirements, by satisfy the Open-Close Principal, we restructured the whole Payment
 * Process by creating an Interface IPaymentProcessor which holds the basic method signatures for payment processing.
 * We created the 4 separate payment Processor Class implementing the interface so each now overrides the
 * functionalities with their own definition. So this closes each of those classes to modification , but we will be
 * able to create new Payment processor in future by implementing the interface, so The Payment process
 * system is now open to extensibility.
 * </p>
 * Created by Hassan Sakib Afrin on 21-07-2021
 */
public interface IPaymentProcessor {
    public void processPayment(Order _order, String _security_code);
    public void isPaid(Order _order);
}
