package ood.pattern.factory.example1.AbstractFactoryPattern.pizzas;

import ood.pattern.factory.example1.AbstractFactoryPattern.PizzaIngredientFactory;


// The client of the Abstract Factory is the concrete instances of the Pizza abstract class, say CheesePizza
public class CheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    // To make a pizza, we'd inject a factory to provide the ingredients
    // => each pizza from different regions (boston, nyc, and etc) will depend on the ingredientFactory passed in
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    /**
     * This is where the magic happens
     * The prepare method steps through cheese pizza creation,
     * each time, it gets the ingredient from the ingredientFactory
     */
    void prepare() {

     System.out.println("Preparing " + name);
     dough = ingredientFactory.createDough();
     sauce = ingredientFactory.createSauch();
     cheese = ingredientFactory.createCheese();
    }

}
