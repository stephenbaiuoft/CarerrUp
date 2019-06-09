package ood.design.strategy.example1;

abstract class Character {
    protected WeaponBehavior weapon;
    abstract void fight();
    protected void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
}
