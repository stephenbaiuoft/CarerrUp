package ood.design.strategy.example1;

public class BowAndArrowBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("Use a bow and arrow");
    }
}
