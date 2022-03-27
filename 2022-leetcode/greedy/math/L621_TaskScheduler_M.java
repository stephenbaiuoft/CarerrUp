package greedy.math;

import java.util.Arrays;

public class L621_TaskScheduler_M {
    // Greedy Solution
    // maxIdle you can get is (highestFreq - 1) * n
    // Now insert the next element, B
    // maxIdle can be reduced at most -> Math.min(highestFreq-1, freq_B)
    //          highestFreq -1 is B of same freq as A, (因为只在spacing中insert)
    // A _ _ _ A _ _ _ A
    // maxIdle you can

    // 最后 maxIdle = Math.max(0, maxIdle) 因为可以go negative
    // return maxIdle + tasks.length
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        // keep track of freq
        for (char task: tasks) {
            freq[task - 'A'] += 1;
        }

        Arrays.sort(freq);
        // the largest on the end
        int highest = freq[25];
        // highest -1 spacing, each of n
        int maxIdle = (highest -1) * n;

        for (int i = 24; i > -1; i--) {
            if (freq[i] > 0) {
                // highest -1 -> the most you can reduce the next is same freq for idle
                maxIdle -= Math.min(highest-1, freq[i]);
            }
        }

        // this can go negative
        maxIdle = Math.max(0, maxIdle);

        return tasks.length + maxIdle;

    }
}
