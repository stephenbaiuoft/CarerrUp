package dp;

public class L1067_DigitCountInRangeNonWorking_H {

    public L1067_DigitCountInRangeNonWorking_H() {
        // 223
        int value = digitsCount(0, 625, 1250);
        System.out.println(value);
    }

    // Count number of occurences for digit for up to n
    public int digitsCount(int d, int low, int high) {
        if (d == 0) {
            return countZero(high) - countZero(low-1);
        } else {
            return countDigitD(high, d) - countDigitD(low-1, d);
        }
    }

    // for 0 it's a bit interesting
    public int[] buildZeroDp(int n) {
        int[] dpForOne = new int[11];
        int[] dpForZero = new int[11];
        int base = 1;
        int remain = n;

        for (int i = 1; remain > 0; i++) {
            dpForOne[i] = dpForOne[i-1] * 10 + base;
            // update base by 10 because 去下一位数
            base *= 10;
            // update remain
            remain /= 10;
        }

        // now let's build for dpForZero using dpForOne
        remain = n;
        dpForZero[0] = 1; // For the initial case
        for (int i =1; remain > 0; i++) {
            dpForZero[i] = dpForOne[i-1] * 9 + dpForZero[i-1];
            remain /=10;
        }

        return dpForZero;
    }

    // another signature
    public int countZero(int n) {
        int highIndex = 0;
        int base = 1;
        int copy = n;
        while (copy > 0) {
            highIndex += 1;
            copy /= 10;
            base *= 10;
        }


        base /=10; // the highIndex is 1XXX and base should be XXX
        int dp[] = buildZeroDp(n);
        return countZero(n, highIndex, base, dp);
    }

    // Actually counts zero
    public int countZero(int n, int curIndex, int curBase, int[] dp) {
        // base condition
        if (curIndex < 1) return 0;

        int div = n / curBase;
        curBase /= 10;
        return dp[curIndex-1] * div + countZero(n%10,  curIndex-1, curBase, dp);

    }

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
