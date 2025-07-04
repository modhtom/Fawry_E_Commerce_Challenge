package models;

import java.util.Date;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public void decreaseQuantity(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be positive");
        if (quantity < amount) throw new IllegalArgumentException("Our stock is not enough for this order please try again later.");
        this.quantity -= amount;
    }

    public abstract boolean isExpired();

    public abstract boolean requiresShipping();
}

abstract class ExpirableProduct extends Product {
    protected Date expiryDate;

    public ExpirableProduct(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return new Date().after(expiryDate);
    }
}

abstract class NonExpirableProduct extends Product {
    public NonExpirableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}