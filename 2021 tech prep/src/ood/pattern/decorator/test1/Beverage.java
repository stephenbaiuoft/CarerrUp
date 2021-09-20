package ood.pattern.decorator.test1;

public abstract class Beverage {
    String description = "Unknown";
    double price = 0.0;

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
