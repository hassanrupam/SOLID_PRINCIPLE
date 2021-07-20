package com.hassan.core;

import java.util.ArrayList;
import java.util.List;

/**
 * The Purpose of this class is to show the violation of Single Responsibility Principal
 * we can make while creating any class.
 * <p>
 * The class contains a demo or Mock of Order and Payment System which is kept simple
 * just for the sake of simplicity to understand the Single Responsibility Principal
 * <p>
 * Here the class order has the responsibility of
 * adding items to the order            ->  void add_Item(String _itemName, Double _quantity, Double _price),
 * Calculating Total price of the order -> Double totalPrice()
 * Process Payments                     -> void processPayment(String _type, String _security_code)
 * and Checking if Payment is Done      -> public void isPaid()
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

    //region PUBLIC METHODS
    public void add_Item(String _itemName, Double _quantity, Double _price) {
        this.itemList.add(new Item(_itemName, _quantity, _price));
    }

    public Double totalPrice() {
        return itemList.stream()
                .mapToDouble(_item -> _item.getQuantity() * _item.getPrice())
                .sum();
    }

    public void processPayment(String _type, String _security_code) {
        if (_type.equals("CARD")) {
            System.out.println("Processing Card Payment");
            System.out.println("Security Code for order : " + this.orderNumber + " is : " + _security_code);
            this.isPaid = true;
        } else if (_type.equals("ONLINE")) {
            System.out.println("Processing Online Payment");
            System.out.println("Security Code for order : " + this.orderNumber + " is : " + _security_code);
            this.isPaid = true;
        } else {
            System.out.println("Unknown Payment Type");
        }
    }

    public void isPaid() {
        if (this.isPaid.equals(true)) {
            System.out.println("Payment is Paid");
        } else {
            System.out.println("Payment is Pending");
        }
    }
    //endregion
}
