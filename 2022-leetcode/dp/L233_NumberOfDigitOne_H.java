package dp;

public class L233_NumberOfDigitOne_H {

    public int countDigitOne(int n) {
        // n is up to 10^9
        // dp代表每一位上有几个1， 比如 十位数上有 10个1 from 10->19 个位数上有1个1 from 0-9, 所以
        // 你把数字写下来 类似下面这么看
        /**
         * 00
         * 01 ->base中一段落
         * ..
         *
         * 09
         * 10
         * 11 ->base中一段落
         * ..
         * 19
         *
         * ..
         *
         *
         * 90
         * 91 ->base中一段落
         * ...
         *
         * 99
         *
         * 那base 代表的意思是 在个位数中 0-9这些个base 在10^n n位数的时候 能有多少个1
         * 比如 十位数 那么base = 10 因为 10->11->19, 20->21->29, ..., 90->91->99
         *  base = 10 = ((99 + 1)/10) * 1 = 10 因为是0-99， 从0开始 所以100 个数字， 每个都会有个 0-9这样的区域 所以有10个区域 每个区域有 1个1
         *
         * 当 百位置数的时候 n = 3,
         * 000
         * 001
         * ..
         * 009
         * 010
         * ...
         * ...
         *
         *
         * 991
         * ...
         * 999
         *
         * base = (1000/10) * 1 = 100
         * n = 3
         *
         * 所以
         * dp[m] = dp[m-1] * 10 + base  因为dp[m] 是意味着你把 dp[m-1] * 10 放大10倍 外加一个base
         */

        int[] dp = new int[11];
        int rest = n;
        // 0-9 有几个1， 然后
        int base = 1;
        int count = 0;
        for(int i = 1; rest > 0; i++) {
            dp[i] = dp[i-1] * 10 + base;
            // base 从1 -n嘛
            base *= 10;
            rest = rest / 10;
        }

        // 10^9
        base = 10^9;
        rest = n;
        // 第几位, 先从 10, 但是 其实是第9位 当你算的时候
        int index = 10;

        while (rest > 0 && index >= 1) {
            if(rest >= base) {
                int dividend = rest / base;
                rest = rest % base;
                if(dividend == 1) {
                    count += dp[index-1] * 1 + (rest + 1); // rest (1 to rest) + 0 (1) => rest + 1
                }
                else {
                    count += dp[index-1] * dividend + base; // dividend (0, 1, ... to dividend) - 1, where the 1 is the base as 1XXX, where 0XXX is the base that counts 1XX0 - 1XXX => base
                }
            }
            index--;
            base /= 10;
        }
        return count;
    }
}
