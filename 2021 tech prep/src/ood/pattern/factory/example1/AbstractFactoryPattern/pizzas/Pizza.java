package ood.pattern.factory.example1.AbstractFactoryPattern.pizzas;

import ood.pattern.factory.example1.AbstractFactoryPattern.ingredients.*;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;

    // The client of the Abstract Factory is the concrete instances of the Pizza abstract class, say CheesePizza
    abstract void prepare();

    /**
     * The following non-abstract of Pizza methods are what Pizza should know
     *
     * It doesn't care how to prepare, but it knows bake, cut, box, which is common for all pizzas
     */
    void bake() {
        System.out.println("Bake for 25 minutes ");
    }

    void cut() {
        System.out.println("Cut into slices ");
    }

    void box() {
        System.out.println("Put into a box");
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    public String toString() {
        return "";
    };
}
