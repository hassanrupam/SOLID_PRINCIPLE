# Liskov-Substitution Principle
* **Liskov-Substitution Principle** -  Child classes should never break the parent class type definitions.

Here you will find two seperate projects to demonstrate the Open-Close Principle.
  1. **[LSP_Violation](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/LiskovSubstitutionPrinciple/LSP_Violation)** 
  2. **[LSP_Solution](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/LiskovSubstitutionPrinciple/LSP_Solution)**
  
## **Project Name : [LSP_Violation](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/LiskovSubstitutionPrinciple/LSP_Violation)** ->
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


A brief reminder what we did so far with the example is-> As per implementing the new requirements, by satisfy the Open-Close Principal, 
we restructured the whole Payment Process by creating an Interface IPaymentProcessor which holds the basic method signatures for payment processing.
We created the 4 separate payment Processor Class implementing the interface so each now overrides the
functionalities with their own definition. So this closes each of those classes to modification , but we will be
able to create new Payment processor in future by implementing the interface, so The Payment process
system is now open to extensibility.

Now, to demonstrate the **Liskov-Substitution Principle**, let's take a look into the 4 Payment Processor Classes we created. To demonstrate the 
**Liskov-Substitution** violation, Let's take a look into the *processPayment(..)* method, where the parameters are *_order (Order)* 
and *_security_code (String)*. As the Interface **IPaymentProcessor** contains the _processPayment(..)_ method signature with 
these two parameter. But for the **CardPaymentProcessor** let's assume we won't need the Security Code, instead we need a
Card Number. But as we can use the *_security_code (String)* to disguise as an Card Number without changing any structure 
of the Code and it will be fully functional, we might think it's a good idea. But in our case this may reduce the code 
readability and confusion may arise very easily.
So the class **CardPaymentProcessor** now looks like this ->
```java
public class CardPaymentProcessor implements IPaymentProcessor{

    //region PRIVATE FIELDS
    private final String visaCardPrefix = "4";
    //endregion

    //region PUBLIC METHODS
    @Override
    public void processPayment(Order _order, String _security_code) {
        System.out.println("Processing Card Payment");
        if(isValidCardNumber(_security_code)){
            System.out.println("Payment Done From Card : "+ _security_code +" for order : " + _order.getOrderNumber());
        }else{
            System.out.println("The Card is not Valid");
        }

        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
    //endregion

    //region PRIVATE METHODS
    private Boolean isValidCardNumber(String _cardNumber){
        List<String> sections = Arrays.asList(_cardNumber.split("-"));

        if(sections.size()==4){
            if(sections.get(0).trim().substring(0,1).equals(visaCardPrefix)){
                List<String> verifiedSections= sections.stream().filter(eachSection-> eachSection.length()==4).collect(Collectors.toList());
                return sections.size()==verifiedSections.size();
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    //endregion
}
```

The same behaviour is affected also in **CryptoCurrencyPaymentProcessor** and **MobileBankingPaymentProcessor** , which use the 
*_security_code (String)* as  **Email Address** and **Cell Number** respectively. The beahvious is only followed by the 
**OnlinePaymentProcessor** which uses the *_security_code (String)* as it was intended.

So here we can see that even though the code is functional ut it seems the parent **IPaymentProcessor** is not having the common 
properties and behaviours to be implied on the child. In other words, the child classes are not fully substitutable with the 
parent class as *processPayment(..)* method contains two paramater from which the second parameter *_security_code (String)* 
is utilized for seperate behaviour in seperate clsses. So this is not a common attribute that all the child will use.
So childs are not fully substitutable with the parent class, which violates the **Liskov-Substitution Principle** 


To satisfy the Liskov-Substitution Principle, we can see the solution **"LSP_Solution"**

## **Project Name : [LSP_Solution](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/LiskovSubstitutionPrinciple/LSP_Solution)** ->
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

The **Liskov-Substitution Principle** states that "Child classes should never break the parent class type definitions".
To simplify we can say, the opposite as - We should not put any behaviour or property in a parent which is not
utilized by all the child classes. All the common things, either attributes/properties or any behaviours for all
the child should only be described in parent. So that Each child would be substitutable of the parent class.

In our case we saw in the **LSP_Violation** that all the Payment Processors had different behaviour in terms of the
*processPayment(..)* method. We say the **OnlinePaymentProcessor** was utilizing *_security_code(String)* parameter as
it was intended. But **CryptoCurrencyPaymentProcessor** used it as email, **CardPaymentProcessor** used it as Card Number
and the **MobileBankingPaymentProcessor** used it as Cell Number. So it seems all the classes have different need
in the second parameter. This violates the **Liskov-Substitution Principle** as the parent defines a common attribute
*_security_code (String)* which is not common for all the classes which implements the *processPayment(..)* behaviour.
So to satisfy the **Liskov-Substitution Principle** we should remove this from the parent and restructure our child
classes accordingly.

```java
public interface IPaymentProcessor {
    public void processPayment(Order _order);
    public void isPaid(Order _order);
}
```

As we have removes the *_security_code (String)* attribute from the behaviour *processPayment(..)* from the parent
now we have to remove this from our child classes too. Here We removed the parameter from the method but we need the
**cardNumber** attribute which we used inside the *processPayment(..)* in our **LSP_Violation** with the *_security_code (String)*.
As the **cardNumber** attribute is only needed for **CardPaymentProcessor** class so we define it here and not is the
parent as it is not a common attribute. This Satisfies the **Liskov-Substitute Principle**.

The Class **CardPaymentProcessor**  Now Looks like this ->
```java
public class CardPaymentProcessor implements IPaymentProcessor{

    //region PRIVATE FIELDS
    private String cardNumber;
    private final String visaCardPrefix="4";
    //endregion

    //region CONSTRUCTORS
    public CardPaymentProcessor(String _cardNumber) {
        this.cardNumber = _cardNumber;
    }
    //endregion

    //region PUBLIC METHODS
    @Override
    public void processPayment(Order _order) {
        System.out.println("Processing Card Payment");
        if(isValidCardNumber(this.cardNumber)){
            System.out.println("Payment Done From Card : "+ this.cardNumber +" for order : " + _order.getOrderNumber());
        }else{
            System.out.println("The Card is not Valid");
        }

        _order.setPaid(true);
    }

    @Override
    public void isPaid(Order _order) {
        if (!_order.getPaid().equals(true)) System.out.println("Payment is Pending");
        else System.out.println("Payment is Paid");
    }
    //endregion

    //region PRIVATE METHODS
    private Boolean isValidCardNumber(String _cardNumber){
        List<String> sections = Arrays.asList(_cardNumber.split("-"));

        if(sections.size()==4){
            if(sections.get(0).trim().substring(0,1).equals(visaCardPrefix)){
                List<String> verifiedSections= sections.stream().filter(eachSection-> eachSection.length()==4).collect(Collectors.toList());
                return sections.size()==verifiedSections.size();
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    //endregion
}
```

So while calling the methods in implementation in the **Main** class, we now pass the child classes own attribute as a parameter in the Constructor like->
```java
	Order thirdOrder =  new Order("ORD-003");
	thirdOrder.add_Item("KZ-ZST-Pro Air Phone",2.0,1150.0);

	System.out.println("Total Price : " + thirdOrder.totalPrice());
	CardPaymentProcessor cardPaymentProcessor = new CardPaymentProcessor("4XXX-XXXX-XXXX-XXXX");
	cardPaymentProcessor.isPaid(thirdOrder);
	cardPaymentProcessor.processPayment(thirdOrder);
	cardPaymentProcessor.isPaid(thirdOrder);
```



The same seperation of un-common attributes are doneint the other 3 payment processor classes as well.
So all the child classes now are fully substitutabble y the parent class as parent contains only the common attributes 
which are used by all the childs. And this satisfies the **Liskov-Substitution Principle**

## **Conclusion**
So hopefully we have a better understanding of the **Liskov-Substitution Principle** with the simple example.

Why should we consider to follow this Principle?
### **The Benefits**
* __Code Reusability__
-> If client code cannot substitute a superclass reference with a subclass object freely, it would be forced to do instanceof checks and specially handle some subclasses. 
If this kind of conditional code is spread across the codebase, it will be difficult to maintain.


* __Maintainability__
-> Every time we add or modify a subclass, we would have to comb through the codebase and change multiple places. This is difficult and error-prone.

* __Enhance the Program__
-> It also defeats the purpose of introducing the supertype abstraction in the first place which is to make it easy to enhance the program.It also defeats the purpose of introducing the supertype abstraction in the first place which is to make it easy to enhance the program.



<sub>Reach me out for any further querues on</sub>
 * <sub>**[LinkedIn](https://www.linkedin.com/in/hassanrupam/)**</sub>
 * <sub>**[Facebook](https://www.facebook.com/hassan.sakib/)**</sub>
 * <sub>**[HackerRank](https://www.hackerrank.com/ID15103144)**</sub>
 * <sub>**[StackExchange](https://stackexchange.com/users/12605274/hassan-sakib-rupam)**</sub>
 * <sub>**[HackThisSite](https://www.hackthissite.org/user/view/_d4RKN355/)**</sub>
 * <sub>**Or Email me @ [hassanrupam@gmail.com](mailto:hassanrupam@gmail.com)**</sub>

<sub><sup>:copyright: Hassan Sakib Afrin</sup></sub>
