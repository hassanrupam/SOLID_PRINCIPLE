# Single Responsibility Principle

* **Single responsibility principle** -  A class should have one, and only one, reason to change.
*  Here you will find two seperate projects 

* **Violation** -
** SRP_Violation ->
 * Constains Classes->  Item, Order, Main
 * <p>
 * The class ORDER contains a demo or Mock of Order and Payment System which is kept simple
 * just for the sake of simplicity to understand the Single Responsibility Principal
 * <p>
 * Here the class order has the responsibility of
 * adding items to the order            ->  void add_Item(String _itemName, Double _quantity, Double _price),
 * Calculating Total price of the order -> Double totalPrice()
 * Process Payments                     -> void processPayment(String _type, String _security_code)
 * and Checking if Payment is Done      -> public void isPaid()
 * <p>
 * The class Item is just a simple POJO to contain the item information in the Order. 
 * <p>
 * The class Main is to just demonstrate the Birdseye outcome of the Program. 
 * <p>
 * Now as per the Single Responsibility Principal, One class should have one and only one reason to change,
 * Meaning one class should consist of only related and a single responsibility.
 * For making our code to satisfy the Single responsibility Principal we can see the SRP_Solution project


** SRP_Solution ->
 * Constains Classes->  Item, Order, PaymentProcessor, Main
 * <p>
 * As per the Single Responsibility Principal, It states that -> A class should have one, and only one, reason to change.
 * Meaning A class should have only one responsibility to take care of, and those must be related with each other.
 * Here We saw one class Order had responsibilities to add items and calculate total price for the order.
 * The class also had the payment processing and checking if payment is done which should not be a responsibility of order itself
 * So We should get rid of the functionalities from the Order Class
 * <p>
 * So now, the class Order has the responsibility of
 * adding items to the order            ->  void add_Item(String _itemName, Double _quantity, Double _price),
 * Calculating Total price of the order -> Double totalPrice()
 * <p>
 * the class PaymentProcessor has the responsibility of
 * Process Payments                     -> void processPayment(String _type, String _security_code)
 * and Checking if Payment is Done      -> public void isPaid()
 * <p>
 * The class Item is just a simple POJO to contain the item information in the Order. 
 * <p>
 * The class Main is to just demonstrate the Birdseye outcome of the Program. 
 * <p>
