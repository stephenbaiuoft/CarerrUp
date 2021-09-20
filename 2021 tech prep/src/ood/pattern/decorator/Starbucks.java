package ood.pattern.decorator;

public class Starbucks {
    public static void main(String args[]) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $ " + beverage.getCost());

        Beverage beverage2 = new HouseBlend();
        // Wrap it with Mocha once
        beverage2 = new Mocha(beverage2);
        // Wrap it with Mocha twice
        beverage2 = new Mocha(beverage2);
        // Wrap it with Whip
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $ " + beverage2.getCost());

    }
}
