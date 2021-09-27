package ood.pattern.factory.example1.AbstractFactoryPattern;

// high-level abstraction of factory method

import ood.pattern.factory.example1.AbstractFactoryPattern.pizzas.CheesePizza;
import ood.pattern.factory.example1.AbstractFactoryPattern.pizzas.ClamPizza;
import ood.pattern.factory.example1.AbstractFactoryPattern.pizzas.Pizza;

/**
 * You need to implement a PizzaStore, what do you need to do???
 *
 *
 * Invert your thinking (Dependency Inversion Principle)
 * You start @ pizzas, and think about how you can abstract
 *
 * -> from abstract Pizza
 * -> I should design Pizza Store and not worry about Pizza classes
 *
 */
public class NYPizzaStore extends PizzaStore {

    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        // The NY store is composed with a NY pizza ingredient factory. This will be used
        // to produce the ingredients for all NY pizzas
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
        } else {
            System.out.println("Done");
        }

        return pizza;
    }
}
