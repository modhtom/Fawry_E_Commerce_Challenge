package models;

import java.util.Date;
import interfaces.Shippable;

public class Biscuits extends ExpirableProduct implements Shippable {
    private double weight;

    public Biscuits(String name, double price, int quantity, Date expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override public boolean requiresShipping() { return true; }
    @Override public double getWeight() { return weight; }
}