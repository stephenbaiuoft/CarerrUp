package June;

import java.util.Arrays;

public class L683_KEmptySlots_H {
    public L683_KEmptySlots_H() {
        int[] flowers = new int[] {
                3,9,2,8,1,6,10,5,4,7,1
        };
        int k = 1;

        int index = kEmptySlots(flowers, k);

    }

    public int kEmptySlots(int[] flowers, int k) {
        int interval = k + 1;
        int n = flowers.length;
        int bucketCount = n / interval + 1;
        int[] lB = new int[bucketCount];
        Arrays.fill(lB, Integer.MAX_VALUE);

        int[] hB = new int[bucketCount];
        Arrays.fill(hB, Integer.MIN_VALUE);

        for(int i = 0; i < flowers.length - k; i ++) {
            int x = flowers[i];
            int p = x/ interval;

            if (x < lB[p]) {
                lB[p] = x;
                if (p > 0 && hB[p - 1] == x - interval) {
                    return i + 1;
                }
            }
            if (x >= hB[p]) {
                hB[p] = x;
                if ( p < bucketCount - 1 && lB[p+1] == x + interval) {
                    return i + 1;
                }
            }
        }

        return - 1;
    }
}
