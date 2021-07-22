# Open-Close Principle
* **Single Responsibility Principle** -  Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

Here you will find two seperate projects to demonstrate the Open-Close Principle.
  1. **[OCP_Violation](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/OpenClosePrinciple/OCP_Violation)** 
  2. **[OCP_Solution](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/OpenClosePrinciple/OCP_Solution)**
  
## **Project Name : [OCP_Violation](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/OpenClosePrinciple/OCP_Violation)** ->
**Constains Classes->** 
* **_Item_** 
* **_Order_**
* **_PaymentProcessor_**
* **_Main_**


The class **_PaymentProcessor_** show the violation of __Open-Close Principle__.
From the previous Solution of Single Responsibility Principle, we had separated the Payment Processing Functionality to a new Class. 
We can see that on the Project __"SRP_Solution"__. There we can see that our Payment processor could process __CARD__ and __ONLINE__ payments 
in the _processPayment(..)_ Method. 
```java
public void processPayment(String _type, Order _order, String _security_code) {
        if (_type.equals("CARD")) {
            System.out.println("Processing Card Payment");
            System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
            _order.setPaid(true);
        } else if (_type.equals("ONLINE")) {
            System.out.println("Processing Online Payment");
            System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
            _order.setPaid(true);
        } else {
            System.out.println("Unknown Payment Type");
        }
    }
```
But now , a new Request for change came which specifies to add _CryptoCurrency_ and _Mobile Banking_ Payments in the
Payments Processor.

So if we think generally, we would implement the new requirement that came in the same method. As we can see we had
been keeping the _processPayment(..)_ Method very simple which takes the Type as argument and processes Accordingly
with a nested if else section. That's What we did here, We added two nested if else section which can now process
Crypto Currency and Mobile Banking Payments.

According to our thinking, if we add the nested if else for both Crypto and Mobile Payment system then our method will
look like this ->
```java
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
```
But this violates the __Open-Close Principle__. Beacuse in future if more payment process are added, we have  to keep modifying the 
same _processPayment(..)_ over and over again. There are less scope of reusibility and also it will be hard to maintain beaucse 
whenever a new processor is added we need to check if it had impacted any other functionality of the whole class in any way.

To satisfy the Open-Close Principle, we can see the solution **"OCP_Solution"**

## **Project Name : [OCP_Solution](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/OpenClosePrinciple/OCP_Solution)** ->
**Constains Interfcae->** 
* **_IPaymentProcessor_** 

**Constains Classes->** 
* **_Item_**
* **_Order_**
* **_CardPaymentProcessor_** 
* **_OnlinePaymentProcessor_** 
* **_CryptoCurrencyPaymentProcessor_** 
* **_MobileBankingPaymentProcessor_** 
* **_Main_**

The Purpose of **_IPaymentProcessor_**  is to show the solution of the violation of Open-Close Principle we saw in the
__OCP_Violation__ project.

To integrate the new requirements of _CryptoCurrency_ and _Mobile Banking_ Payments If we keep modifying Our previous
__PaymentProcessor__ Class, then It will violate the Open-Close Principle.

__Open-Close Principle states__ that , Software entities (classes, modules, functions, etc.) should be open for
__extension__, but closed for __modification__. Which means, while developing we should always think for the future
extensibility. Classes , Modules or Functions, everything should be written in such a way so that it can be extended
__without modifying__ the already tested ones. This ensures less cohesion on objects.

As per implementing the new requirements, by satisfy the __Open-Close Principle__, we restructured the whole Payment
Process by creating an Interface **_IPaymentProcessor_** which holds the basic method signatures for payment processing.
We created the 4 separate payment Processor Class implementing the interface so each now overrides the
functionalities with their own definition. 

-> **_CardPaymentProcessor_**
```java
/**
 * The Card Payment processor can hold it's own definition of processPayment(..) method. So it is easier to maintain
 * and is closed for minimum modification if any future change occurs in any requirements. But as IPaymentProcessor
 * is just the signature of how a Payment Process should be, so we are open to any new Payment Processor
 * that might come in future
 *
 * Created by Hassan Sakib Afrin on 21-07-2021
 */
public class CardPaymentProcessor implements IPaymentProcessor{
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Card Payment");
        System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
}
```
-> **_OnlinePaymentProcessor_**
```java
/**
 * The Online Payment processor can hold it's own definition of processPayment(..) method. So it is easier to maintain
 * and is closed for minimum modification if any future change occurs in any requirements. But as IPaymentProcessor
 * is just the signature of how a Payment Process should be, so we are open to any new Payment Processor
 * that might come in future
 *
 * Created by Hassan Sakib Afrin on 21-07-2021
 */
public class OnlinePaymentProcessor implements IPaymentProcessor{
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Online Payment");
        System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
}
```
-> **_CryptoCurrencyPaymentProcessor_**
```java
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
```
-> **_MobileBankingPaymentProcessor_**
```java
/**
 * The Mobile Banking processor can hold it's own definition of processPayment(..) method. So it is easier to maintain
 * and is closed for minimum modification if any future change occurs in any requirements. But as IPaymentProcessor
 * is just the signature of how a Payment Process should be, so we are open to any new Payment Processor
 * that might come in future
 *
 * Created by Hassan Sakib Afrin on 21-07-2021
 */
public class MobileBankingPaymentProcessor implements IPaymentProcessor{
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Mobile Banking Payment");
        System.out.println("Security Code for order : " + _order.getOrderNumber() + " is : " + _security_code);
        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
}
```
So this closes each of those classes to modification , but we will be
able to create new Payment processor in future by implementing the interface, so The Payment process
system is now open to extensibility.

## **Conclusion**
So hopefully we have a better understanding of the **Open-Close Principle** with the simple example.

Why should we consider to follow this Principle?
### **The Benefits**
* __Extensibility__
-> "When a single change to a program results in a cascade of changes to dependent modules, that program exhibits the undesirable attributes that we have come to associate with 'bad' design. The program becomes fragile, rigid, unpredictable, and unreusable. The open-closed principle attacks this in a very straightforward way. It says that you should design modules that never change. When requirements change, you extend the behavior of such modules by adding new code, not by changing old code that already works."
— **_Robert Martin_** 

* __Maintainability__
-> The main benefit of this approach is that an interface introduces an additional level of abstraction which enables loose coupling. The implementations of an interface are independent of each other and don’t need to share any code. 
Thus, you can easily cope-up with client's keep changing requirements. Very useful in agile methodologies.

* __Flexibility__
-> The open-closed principle also applies to plugin and middleware architecture. In that case, your base software entity is your application core functionality.
In the case of plugins, you have a base or core module that can be plugged with new features and functionality through a common gateway interface. A good example of this is web browser extensions. 



<sub>Reach me out for any further querues on</sub>
 * <sub>**[LinkedIn](https://www.linkedin.com/in/hassanrupam/)**</sub>
 * <sub>**[Facebook](https://www.facebook.com/hassan.sakib/)**</sub>
 * <sub>**[HackerRank](https://www.hackerrank.com/ID15103144)**</sub>
 * <sub>**[StackExchange](https://stackexchange.com/users/12605274/hassan-sakib-rupam)**</sub>
 * <sub>**[HackThisSite](https://www.hackthissite.org/user/view/_d4RKN355/)**</sub>
 * <sub>**Or Email me @ [hassanrupam@gmail.com](mailto:hassanrupam@gmail.com)**</sub>

<sub><sup>:copyright: Hassan Sakib Afrin</sup></sub>
