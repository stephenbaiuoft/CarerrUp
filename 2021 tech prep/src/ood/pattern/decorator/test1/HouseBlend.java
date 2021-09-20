package ood.pattern.decorator.test1;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "HouseBlend";
        price = 1.5;
    }

    public double getCost() {
        return price;
    }
}
