package ood.pattern.decorator;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    public double getCost() {
        return 1.99;
    }
}
