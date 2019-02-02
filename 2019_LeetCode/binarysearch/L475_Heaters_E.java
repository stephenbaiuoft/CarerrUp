package binarysearch;

import java.util.Arrays;

public class L475_Heaters_E {
    public L475_Heaters_E() {
    }

    // 自己的思路了 good usage of the while-loop case
    // 然后 while-loop让你自己free update index！ 很重要
    // 一般有2个variable 大概率考虑 while-loop
    // 但是for-loop 在2个variable 一个variable是fix的情况下 也很好用 朋友
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0;
        int j = 0;
        int minD = 0;
        // cases to consider
        // houses[i]  < heaters[j]
        // houses[i] >= heaters[j]
        // i out of boundary && j out of boundary
        // terminating condition
        while (i < houses.length) {
            if (houses[i] < heaters[j]) {
                minD = Math.max(minD, heaters[j] - houses[i]);
                // update i index
                i++;
            }
            else if (houses[i] > heaters[j]) {
                // j is now the last index of heaters
                if (j + 1 == heaters.length) {
                    minD = Math.max(minD, houses[i] - heaters[j]);
                    // update house
                    i++;
                } else if (heaters[j+1] <= houses[i]) {
                    // next heater is still <= houses[i]
                    j++;
                } else { // heaters[j+1] > houses[i]
                    minD = Math.max(minD,
                            Math.min(houses[i] - heaters[j],
                                    heaters[j+1] - houses[i]));
                    // update house index
                    i++;
                }
            } else {
                // equal case for house[i] == heaters[j], so minD is 0
                // but minD is initialized as 0
                // update house index and continue
                i++;
            }
        }

        return minD;
    }
}
