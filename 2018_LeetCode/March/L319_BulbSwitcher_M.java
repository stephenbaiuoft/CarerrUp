package March;

public class L319_BulbSwitcher_M {
    // This is Mathematical Idea!!!! important
    public int bulbSwitch(int n) {
        // idea, given a number, find # of axb pairs it has
        // 1 -> 1, 2 -> 1x2, 3 ->1x3, 5- > 1x5 , 6 -> 1x6,2x3
        // initially, all bulbs are off, and 1,2,3 rounds
        // so only  odd when the number is 4: 2x2 (double 2) or 9:(double 3)
        return (int )Math.sqrt(n);

    }
}
