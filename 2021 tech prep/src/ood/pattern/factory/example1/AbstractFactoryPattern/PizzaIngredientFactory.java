package ood.pattern.factory.example1.AbstractFactoryPattern;

import ood.pattern.factory.example1.AbstractFactoryPattern.ingredients.Cheese;
import ood.pattern.factory.example1.AbstractFactoryPattern.ingredients.Clams;
import ood.pattern.factory.example1.AbstractFactoryPattern.ingredients.Dough;
import ood.pattern.factory.example1.AbstractFactoryPattern.ingredients.Sauce;

public abstract class PizzaIngredientFactory {
    public abstract Dough createDough();
    public abstract Sauce createSauch();
    public abstract Cheese createCheese();
    public abstract Clams createClam();
}
