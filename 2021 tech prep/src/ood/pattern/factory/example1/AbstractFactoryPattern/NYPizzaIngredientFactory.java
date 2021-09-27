package ood.pattern.factory.example1.AbstractFactoryPattern;

import ood.pattern.factory.example1.AbstractFactoryPattern.ingredients.Cheese;
import ood.pattern.factory.example1.AbstractFactoryPattern.ingredients.Clams;
import ood.pattern.factory.example1.AbstractFactoryPattern.ingredients.Dough;
import ood.pattern.factory.example1.AbstractFactoryPattern.ingredients.Sauce;

public class NYPizzaIngredientFactory extends PizzaIngredientFactory {
    public Dough createDough() {
        return new Dough();
    }
    public Sauce createSauch() {
        return new Sauce();
    }
    public Cheese createCheese() {
        return new Cheese();
    }
    public Clams createClam() {
        return new Clams();
    }
}
