# Single Responsibility Principle
* **Single responsibility principle** -  A class should have one, and only one, reason to change.

Here you will find two seperate projects to demonstrate the SIngle Responsibility Principal.
  1. **[SRP_Violation](https://github.com/strangerOfDarkness/SOLID_PRINCIPAL/tree/main/SingleResponsibilityPrincipal/SRP_Violation)** 
  2. **[SRP_Solution](https://github.com/strangerOfDarkness/SOLID_PRINCIPAL/tree/main/SingleResponsibilityPrincipal/SRP_Solution)**
  
## **Project Name : [SRP_Violation](https://github.com/strangerOfDarkness/SOLID_PRINCIPAL/tree/main/SingleResponsibilityPrincipal/SRP_Violation)** ->
**Constains Classes->** 
* **_Item_** 
* **_Order_**
* **_Main_**


The class **_Order_** contains a demo or Mock of Order and Payment System which is kept simple 
just for the sake of simplicity to understand the Single Responsibility Principal

Here the class **_Order_** has the responsibility of -
Funcaitonality | Method Signature
-------------- | ----------------
adding items to the order            | void add_Item(String _itemName, Double _quantity, Double _price),
Calculating Total price of the order | Double totalPrice()
Process Payments                     | void processPayment(String _type, String _security_code)
Checking if Payment is Done          | public void isPaid()


 The class **_Item_** is just a simple POJO to contain the item information in the Order. 
 
 
 The class **_Main_** is to just demonstrate the Birds eye outcome of the Program. 
 
 Now as per the Single Responsibility Principal, One class should have one and only one reason to change,
 Meaning one class should consist of only related and a single responsibility.
 For making our code to satisfy the Single Responsibility Principal we can see the **SRP_Solution** project

## **Project Name : [SRP_Solution](https://github.com/strangerOfDarkness/SOLID_PRINCIPAL/tree/main/SingleResponsibilityPrincipal/SRP_Solution)** ->
**Constains Classes->** 
* **_Item_**
* **_Order_**
* **_PaymentProcessor_** 
* **_Main_**

 As per the Single Responsibility Principal, It states that -> **A class should have one, and only one, reason to change.**
 Meaning A class should have only one responsibility to take care of, and those must be related with each other.
 Here We saw one class **_Order_** had responsibilities to add items and calculate total price for the order.
 The class also had the payment processing and checking if payment is done which should not be a responsibility of order itself
 So We should get rid of the functionalities from the **_Order_** Class


 So now, the class **_Order_** has the responsibility of
 Funcaitonality | Method Signature
-------------- | ----------------
adding items to the order            |  void add_Item(String _itemName, Double _quantity, Double _price),
Calculating Total price of the order | Double totalPrice()
 
And the removed functionality for the payment processing are now served by a new Class named  **_PaymentProcessor_**
The class PaymentProcessor has the responsibility of
 Funcaitonality | Method Signature
-------------- | ----------------
Process Payments                    | void processPayment(String _type, String _security_code)
and Checking if Payment is Done     | public void isPaid()

 
 The class **_Item_** is just a simple POJO to contain the item information in the Order. 

 The class **_Main_** is to just demonstrate the Birdseye outcome of the Program. 

## **Conclusion**
So hopefully we have a better understanding of the **Single Responsibility Principal** with the simple example.

But Why should we consider to follow this principal? The answer is we have some benefits. 
### **The Benefits**
* __The class is easier to understand__
  * When the class only does “one thing”, its interface usually has a small number of methods that are fairly self explanatory. It should also have a small number of member    variables (less than seven-ish).

* __The class is easier to maintain__
  * Changes are isolated, reducing the chance of breaking other unrelated areas of the software. As programming errors are inversely proportional to complexity, being easier to  understand makes the code less prone to bugs.

* __The class is more reusable__
  * If a class has multiple responsibilities, and only one of those is needed in another area of the software, then the other unnecessary responsibilities hinder reusability. Having a single responsibility means the class should be reusable without modification. 


<sub>Reach me out for any further querues on</sub>
 * <sub>**[LinkedIn](https://www.linkedin.com/in/hassanrupam/)**</sub>
 * <sub>**[Facebook](https://www.facebook.com/hassan.sakib/)**</sub>
 * <sub>**[HackerRank](https://www.hackerrank.com/ID15103144)**</sub>
 * <sub>**[StackExchange](https://stackexchange.com/users/12605274/hassan-sakib-rupam)**</sub>
 * <sub>**[HackThisSite](https://www.hackthissite.org/user/view/_d4RKN355/)**</sub>
 * <sub>**Or Email me @ [hassanrupam@gmail.com](mailto:hassanrupam@gmail.com)**</sub>

<sub><sup>:copyright: Hassan Sakib Afrin</sup></sub>
