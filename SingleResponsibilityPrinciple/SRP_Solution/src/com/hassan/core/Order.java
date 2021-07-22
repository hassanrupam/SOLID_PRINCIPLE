package com.hassan.core;

import java.util.ArrayList;
import java.util.List;

/**
 * The Purpose of this class is to show the solution of Single Responsibility Principal
 * of the violation that we saw in the previous project named SRP_Violation
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
 * Created by Hassan Sakib Afrin on 20-07-2021
 */
public class Order {
    //region PRIVATE FIELDS
    final List<Item> itemList = new ArrayList<>();
    private final String orderNumber;
    private Boolean isPaid = false;
    //endregion

    //region CONSTRUCTOR
    public Order(String _orderNumber) {
        this.orderNumber = _orderNumber;
    }
    //endregion

    //region GETTER & SETTER
    public String getOrderNumber() {
        return orderNumber;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
    //endregion

    //region PUBLIC METHODS
    public void add_Item(String _itemName, Double _quantity, Double _price) {
        this.itemList.add(new Item(_itemName, _quantity, _price));
    }

    public Double totalPrice() {
        return itemList.stream()
                .mapToDouble(_item -> _item.getQuantity() * _item.getPrice())
                .sum();
    }
    //endregion
}
