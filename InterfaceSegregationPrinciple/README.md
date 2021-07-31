# Interface Segregation Principle
* **Interface Segregation Principle** - No client should be forced to depend on methods it does not use.

Here you will find two seperate projects to demonstrate the Interface Segregation Principle.
  1. **[ISP_Violation](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/InterfaceSegregationPrinciple/ISP_Violation)** 
  2. **[ISP_Solution](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/InterfaceSegregationPrinciple/ISP_Solution)**
  
## **Project Name : [ISP_Violation](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/InterfaceSegregationPrinciple/ISP_Violation)** ->
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

The Interface Segregation Principle states that  _"No client should be forced to depend on methods it does not use."_
To demonstrate the violation of this principle, let's assume we need Two Factor Authorization for our
payment processing. So we introduce a new behaviour (method) in out interface _verifyTwoFactorAuth()_ which will
be implemented according to the each child class with their own definition for two factor verification.


So the **_IPaymentProcessor_** now looks like this ->
```java
	public interface IPaymentProcessor {
		public void processPayment(Order _order);
		public void isPaid(Order _order);
		public void verifyTwoFactorAuth() throws Exception;
	}
```
Now as the parent has defined the _verifyTwoFactorAuth()_ we must now implement the definition in all the 4 child classes.
But here we assume we don't have any two factor authentication support for **CardPaymentProcessor** and  **CryptoCurrencyPaymentProcessor**.
So we just raised an Exception that it is not supported yet. so the implentation in **CardPaymentProcessor** and  **CryptoCurrencyPaymentProcessor**
looks something like this-> 
```java
    @Override
    public void verifyTwoFactorAuth() throws Exception {
        throw new Exception("Card Payment doesn't support two factor authentication!");
    }
```

We assume we have Two Factor Authentication support for **MobileBankingPaymentProcessor** and **OnlinePaymentProcessor** so we implemented the method
_verifyTwoFactorAuth()_ here properly. In general we would have written all sort of verification process
and sub routines here but for sake of simplicity we kept it simple just by some hard coded text to just
show the concept of **Interface Segregation Principle**.
```java
    @Override
    public void verifyTwoFactorAuth() throws Exception {
        System.out.println("Verifying Two Factor Authentication");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Verification Complete");
    }
```

But here we see that we are forcing the **CardPaymentProcessor** and  **CryptoCurrencyPaymentProcessor** classes to define a method that they doesn't need.
This is volating the **Interface Segregation Principle**.

To satisfy the **Interface Segregation Principle**, we can see the solution **"ISP_Solution"**

## **Project Name : [ISP_Solution](https://github.com/strangerOfDarkness/SOLID_PRINCIPLE/tree/main/InterfaceSegregationPrinciple/ISP_Solution)** ->
**Constains Interfcae->** 
* **_IPaymentProcessor_** 
* **_ITwoFactorAuth_** 

**Constains Classes->** 
* **_Item_**
* **_Order_**
* **_CardPaymentProcessor_** 
* **_OnlinePaymentProcessor_** 
* **_CryptoCurrencyPaymentProcessor_** 
* **_MobileBankingPaymentProcessor_** 
* **_Main_**

To remove the violation we created another interface named **_ITwoFactorAuth_** now which now contains the _verifyTwoFactorAuth()_ method.

```java
public interface IPaymentProcessor {
    public void processPayment(Order _order);
    public void isPaid(Order _order);
}
```

As we have seen two classes supports the behaviour of two factor authentication which are **MobileBankingPaymentProcessor** and **OnlinePaymentProcessor**.
So now, we can just Implement the **_ITwoFactorAuth_** interface along with **_IPaymentProcessor_**  interface to only those
two class and implement the methods with their own behavioural definition.

```java
public class MobileBankingPaymentProcessor implements IPaymentProcessor , ITwoFactorAuth{
      .....
}
```

```java
public class OnlinePaymentProcessor implements IPaymentProcessor , ITwoFactorAuth{
   .....
}
```

And the Other two class **CardPaymentProcessor** and  **CryptoCurrencyPaymentProcessor**can only implement **_IPaymentProcessor_** 
as they don;t support Two Factor Authentication. 
```java
public class CardPaymentProcessor implements IPaymentProcessor{
      .....
}
```

```java
public class CryptoCurrencyPaymentProcessor implements IPaymentProcessor{
   .....
}
```


This now satisfies **Interface Segregation Principle**.



## **Conclusion**
So hopefully we have a better understanding of the **Interface Segregation Principle** with the simple example.

Enforcing ISP gives you following bonuses:
### **The Benefits**
* **High cohesion**
-> Better understandability, robustness


* **Low coupling**
-> better maintainability, high resistance to changes



<sub>Reach me out for any further querues on</sub>
 * <sub>**[LinkedIn](https://www.linkedin.com/in/hassanrupam/)**</sub>
 * <sub>**[Facebook](https://www.facebook.com/hassan.sakib/)**</sub>
 * <sub>**[HackerRank](https://www.hackerrank.com/ID15103144)**</sub>
 * <sub>**[StackExchange](https://stackexchange.com/users/12605274/hassan-sakib-rupam)**</sub>
 * <sub>**[HackThisSite](https://www.hackthissite.org/user/view/_d4RKN355/)**</sub>
 * <sub>**Or Email me @ [hassanrupam@gmail.com](mailto:hassanrupam@gmail.com)**</sub>

<sub><sup>:copyright: Hassan Sakib Afrin</sup></sub>
