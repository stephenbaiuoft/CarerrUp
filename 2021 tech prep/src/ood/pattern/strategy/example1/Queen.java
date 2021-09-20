package ood.pattern.strategy.example1;

public class Queen extends Character{
    public Queen() {
        weapon = new BowAndArrowBehavior();
    }

    @Override
    void fight() {
        weapon.useWeapon();
    }
}
