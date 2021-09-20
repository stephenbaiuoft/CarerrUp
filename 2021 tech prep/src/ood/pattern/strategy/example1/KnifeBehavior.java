package ood.pattern.strategy.example1;

public class KnifeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("put out a knife");
    }
}
