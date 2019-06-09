package ood.design.strategy.example1;

public class DemoExample1 {
    public static void run() {
        Character king = new King();
        Character queen = new Queen();

        System.out.println("King is fighting now");
        king.fight();
        System.out.println("Quuen is fighting now");
        queen.fight();

        System.out.println("Note you can replace their behavior by doing setting weapon, and now check out king behavior");
        king.setWeapon(new BowAndArrowBehavior());
        king.fight();
    }
}
