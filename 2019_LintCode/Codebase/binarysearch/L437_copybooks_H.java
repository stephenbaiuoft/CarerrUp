package Codebase.binarysearch;

import java.util.Arrays;

public class L437_copybooks_H {
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length < 1) return 0;

        int lower = Arrays.stream(pages).min().getAsInt() ;
        long sum = Arrays.stream(pages).sum();
        int upper = sum < Integer.MAX_VALUE ? (int)sum: Integer.MAX_VALUE;

        while (lower < upper) { // +1 offset to avoid infinite loop
            int mid = lower + (upper - lower) / 2;
            if (check(pages, mid, k)) {
                upper = mid;
            } else {
                lower = mid+1;
            }
        }

        if (check(pages, lower, k)) {
            return lower;
        }
        return lower+1;
    }

    private boolean check(int[] pages, int limit, int k) {
        int curNum = 1;
        int limitTreshold = limit; // default to 0 so it will be initialized
        for (int bookCopyTime : pages) {
            if (bookCopyTime > limit) { // too low
                return false;
            }
            if (bookCopyTime > limitTreshold) { // when it's larger, you need 1 more limitedThreshold for this
                curNum++;
                if (curNum > k) { // false and break early
                    return false;
                }
                limitTreshold = limit; // use up 1 limitThreshold, and
            }
            limitTreshold -= bookCopyTime;
        }

        return true; // default to true as less than k for sure
    }
}
