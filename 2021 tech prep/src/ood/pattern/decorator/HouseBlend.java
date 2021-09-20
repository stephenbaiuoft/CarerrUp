package ood.pattern.decorator;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "HouseBlend";
    }

    public double getCost() {
        return 1.5;
    }
}
