package ood.pattern.decorator.test1;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
        price = 1.99;
    }

    public double getCost() {
        return price;
    }
}
