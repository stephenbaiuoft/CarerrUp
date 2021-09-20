package ood.pattern.strategy.example1;

public class King extends Character {
    public King() {
        weapon = new KnifeBehavior();
    }

    @Override
    void fight() {
        weapon.useWeapon();
    }
}
