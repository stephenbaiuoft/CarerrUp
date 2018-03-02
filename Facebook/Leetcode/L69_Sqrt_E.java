package Leetcode;

public class L69_Sqrt_E {
    public int mySqrt(int x) {
        if(x <= 0) {
            return x;
        }

        int sig = 0;
        int rez = 1;
        while( (long) (1<< sig) * (long) (1 << sig) <= x) {
            sig ++;
        }

        sig -= 1;
        rez = 1 << sig;
        for ( int i = sig -1; i>= 0; i --) {
            long tmp = (rez | 1 << i);
            if ( tmp * tmp <= x) {
                rez = (int) tmp;
            }
        }

        return rez;
    }
}
