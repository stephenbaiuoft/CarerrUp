package ood.pattern.decorator;

// Mocha is a decorator, so we extend CondimentDecorator
// Remember decorator is a wrapper
public class Mocha extends CondimentDecorator {
    // We're going to instantiate Mocha with a reference to a Beverage
    // This is an instance to hold the beverage we are wrapping
    Beverage beverage;

    public Mocha(Beverage beverage) {
        // This is the way to set this instance variable to the object
        // we are wrapping.
        // This is done through constructor, but we can do some other methods (Flexible)
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        // This is for description to include each decorating of the beverage
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double getCost() {
        // base cost for mocha is 0.2
        return beverage.getCost() + 0.20;
    }
}
