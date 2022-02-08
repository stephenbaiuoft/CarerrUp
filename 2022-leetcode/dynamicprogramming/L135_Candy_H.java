package dynamicprogramming;

import java.util.Arrays;

public class L135_Candy_H {
    public L135_Candy_H() {
        int rez = candy(new int[] {
                1, 0, 2
        });
    }

    public int candy(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }

    public int candySlowLoop(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;

        // find peak indices, and for those we need 2 candies (note peak includes init and end)
        // other indices, we only need 1
        int[] leftToRight = new int[ratings.length];
        int[] rightToLeft = new int[ratings.length];

        int curMin = 1;
        for (int i = 0; i < ratings.length; i++) {
            leftToRight[i] = curMin;
            if (i + 1 < ratings.length && ratings[i+1] > ratings[i]) {
                curMin++;
            } else {
                curMin = 1;
            }
        }

        curMin = 1;
        for (int i = ratings.length - 1; i > -1; i--) {
            rightToLeft[i] = curMin;
            if (i - 1 > -1 && ratings[i-1] > ratings[i]) {
                curMin++;
            } else {
                curMin = 1;
            }
        }

        int tot = 0;
        for (int i = 0; i < ratings.length; i++) {
            tot += Math.max(leftToRight[i], rightToLeft[i]);
        }

        return tot;
    }
}
