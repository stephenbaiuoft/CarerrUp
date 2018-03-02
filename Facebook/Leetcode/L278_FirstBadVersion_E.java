package Leetcode;

public class L278_FirstBadVersion_E {

    // isBadVersion here is dummpy fcn
    public boolean isBadVersion(int in) {
        return in > 0;
    }

    public int firstBadVersion(int n) {
        if (n < 1) return n;
        int low = 1;
        int high = n;
        int mid = 0;

        while( low < high - 1 ) {
            mid = (high - low)/ 2 + low ;
            // case where mid is bad, then
            if (isBadVersion(mid)) {
                high = mid;
            }
            else{
                low = mid;
            }
        }

        if (isBadVersion(low)){
            return low;
        } else {
            return high;
        }
    }
}
