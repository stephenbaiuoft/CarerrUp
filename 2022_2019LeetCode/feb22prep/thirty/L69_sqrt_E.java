package feb22prep.thirty;

public class L69_sqrt_E {

    public int mySqrtC(int x) {
        // Base case!!!! this is only true for x > 2
        if (x < 2) return x;

        // Left start from 1, this is important
        int mid, left = 1, right = x;
        long squared;
        // do binary serach
        while (left < right -1) {
            mid = left + (right - left)/2;
            squared = (long) mid * mid;
            if (squared <= x)  { // --> continue to the left!!!! it's logN
                left = mid;
            }
            else { // squared > x;
                right = mid;
            }

        }

        // we need the smaller chunk;
        return left;

    }


    public int mySqrtB(int x) {
        // Base case!!!! this is only true for x > 2
        if (x < 2) return x;

        // Left start from 1, this is important
        int mid, left = 1, right = x;
        long squared;
        // do binary serach
        while (left < right - 1) {
            mid = left + (right - left)/2;
            squared = (long) mid * mid;
            if (squared == x) return mid;
                //
            else if (squared < x) {
                left = mid;
            } else { // squared > x;
                right = mid;
            }

        }

        // we need the smaller chunk;
        return left;

    }


    public int mySqrt(int x) {
        if (x < 2) return x;


        int mid, left = 2, right = x/2;
        long squared;
        // do binary serach
        while (left <= right) {
            mid = left + (right - left)/2;
            squared = (long) mid * mid;
            if (squared == x) return mid;
                //
            else if (squared < x) {
                left = mid + 1;
            } else { // squared > x;
                right = mid - 1;
            }

        }

        // Return right as right is always the one decrement!!!!
        return right;

    }
}
