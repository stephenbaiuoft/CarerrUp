package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class L1067_DigitCountInRange_H {
    // https://leetcode.com/problems/digit-count-in-range/discuss/726686/log(N)-digit-dp-template-for-all-similar-problems-such-as-1067-1012-233-600-....
    // DP template for counting digits!!!!!!!

    public L1067_DigitCountInRange_H() {
        digitsCount(1, 1, 11);
    }

    public int digitsCount(int d, int low, int high) {

        return helper(d, generateBounds(high), 0, 0, true, true, new Integer[9][9][2][2])
                - helper(d, generateBounds(low - 1), 0, 0, true, true, new Integer[9][9][2][2]);
    }

    private List<Integer> generateBounds(int n) {

        // 1234 -> [1, 2, 3, 4]
        List<Integer> list = new ArrayList<>();
        String s = String.valueOf(n);
        for (char c : s.toCharArray()) {
            list.add(c - '0');
        }
        return list;
    }


    /**
     * Based on hasDigitBound to generate next digit,
     * based on hasLeadingZero to increment count or not,
     * based on hasDigitBound and next digit to determine new hasDigitBound value.
     * @param d
     * @param bounds
     * @param i
     * @param count digit count for current state ( AXXX , 在AXXX中有多少个, 因为 high = 2 * 10^8, 所以 dp[9][9][X][X] 9-1个最多的index 以及9-1个最多的match 因为最大就是8位数
     * @param hasLeadingZero
     * @param hasDigitBound
     * @param dp
     * @return
     */
    private int helper(int d, List<Integer> bounds, int i, int count, boolean hasLeadingZero, boolean hasDigitBound, Integer[][][][] dp) {

        // count表示 这个d 以及在index i这个位置 出现了多少次
        // 所有的count都是最后结算的，
        // 最后的条件是？ i == bounds.size  比如 d = 1, 然后我们111.X count = 3, 112.X, count = 2, 因为i starts from 0, i == bounds.size()是结算条件
        if (i == bounds.size()) return count;

        if (dp[i][count][hasLeadingZero ? 1 : 0][hasDigitBound ? 1 : 0] != null)
            return dp[i][count][hasLeadingZero ? 1 : 0][hasDigitBound ? 1 : 0];

        int res = 0;
        int from = 0, to = hasDigitBound ? bounds.get(i) : 9;

        for (int curD = from; curD <= to; ++curD) {
/**
 *  1, 0, X?
 */
            if (hasLeadingZero && curD == 0) { // leading 0 && curD is 0, you'd have 0, 0, X for nextDigit,
                // Leading 0 is 00000000X, so it needs to be consecutively true
                // because cur digit is zero, so next digit will not have digit-bound
                // unBounded 因为 curD是 [0, To] 之中
                // 不可能出现 leadingZero = true, and To = 0 的情况 因为i是从significant开始的， to > 0 在这个情况
                res += helper(d, bounds, i + 1, count, true, false, dp);
            } else { // !hasLeadingZero, leadingZero will always be false

                // !hasLeadingZero && curD == 0,1,2,3,4, to some X other than d
                // !hasLeadingZero && curD == d (your desired target)

                // curD != to, so the next digit will not have digit bound,
                // 因为 比如 curD = 1, to = 2, 下一位用x表示 那么  1X - 2X， X就会是unbounded

                // if previous digit has digit bound, and current digit == max, then next one will have digit-bound
                res += helper(d, bounds, i + 1, count + (curD == d ? 1 : 0), false, (hasDigitBound && curD == to), dp);

            }
        }

        return dp[i][count][hasLeadingZero ? 1 : 0][hasDigitBound ? 1 : 0] = res;
    }


// ************************************************************************************************************************
// ************************************************************************************************************************

    // This is the template for counting non-zero digits
    public int countDigitD(int n, int d) {
        // for digit 1 to 9, we'd always have the same as count digit as NumberOfDigitOne, similar logic
        int[] dp = new int[11];
        int base = 1; // 0 - 9
        int count = 0;
        int remain = n;
        // build up the dp first, all the way of 10 dp[10]
        for (int i = 1; i <= 10; i++) {
            dp[i] = dp[i-1] * 10 + base;
            base *= 10;
        }

        int digitIndex = 10;
        base = 1000000000;
        while (remain > 0 && digitIndex >= 1) {
            if (remain >= base) {
                int div = remain / base;
                remain = remain % base;

                // div equals d,
                if (div == d) {
                    count += dp[digitIndex-1] * (div) + remain + 1;
                } else if (div < d){
                    count += dp[digitIndex-1] * div;
                } else { // div >d
                    count += dp[digitIndex -1] * (div)  + base;
                }
            }
            digitIndex --;
            base /=10;

        }

        return count;
    }
}
