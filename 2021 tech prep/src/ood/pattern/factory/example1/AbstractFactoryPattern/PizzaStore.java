package ood.pattern.factory.example1.AbstractFactoryPattern;

// high-level abstraction of factory method

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
public abstract class PizzaStore {
    // public abstract Pizza orderPizza();

    protected abstract Pizza createPizza(String item);
}
