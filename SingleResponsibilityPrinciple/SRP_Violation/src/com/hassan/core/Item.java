package com.hassan.core;

/**
 *
 */
class Item {
    //region PRIVATE FIELDS
    private String itemName;
    private Double quantity;
    private Double price;
    //endregion

    //region CONSTRUCTOR
    public Item(String itemName, Double quantity, Double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
    //endregion

    //region GETTER & SETTER
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    //endregion
}
