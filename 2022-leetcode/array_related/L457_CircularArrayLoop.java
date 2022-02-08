package array_related;

/*
* You are given an array of positive and negative integers.
If a number n at an index is positive, then move forward n steps.
Conversely, if it's negative (-n), move backward n steps.
Assume the first element of the array is forward next to the last element,
and the last element is backward next to the first element. Determine if there is a loop in this array. A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be "forward" or "backward'.

Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.

Example 2: Given the array [-1, 2], there is no loop.

Note: The given array is guaranteed to contain no element "0".

Can you do it in O(n) time complexity and O(1) space complexity?
* */


public class L457_CircularArrayLoop {
    //这个还要精辟
    public boolean circularArrayLoopSol(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) continue;
            int stepsToMove = nums[i];
            nums[i] = 0; // 把i个element mark成为0

            int next = (stepsToMove + i + len) % len;

            // check only one element case
            if (next == i) continue;

            while (stepsToMove * nums[next] > 0) { // 因为visited是 0， 所以如果有cycle 一定是会break out of the while-loop
                                                  // 如果没有cycle 就是一直向前走 最后因为是array， 然后mark as visited， 这个while-loop一定是会terminate的
                                                  // 1. 要么 走到一个cycle里面
                                                  // 2. 要么全部走完了 所以visited， 然后最后的时候 if (next == i) return true 来检查
                stepsToMove = nums[next];
                nums[next] = 0;
                next = (next + stepsToMove + len) % len;
            }

            // 这就是最后的检查！ 真得厉害
            if (next == i) return true;

        }
        return false;
    }

    public boolean circularArrayLoop(int[] nums) {
        // 1. mark down nums[i] to 0 s.t i know it has been explored already
        // 2. same direction, --> nums[next] * nums[i] > 0 (trick to do so)
        // 3. in addition, make sure that nums[i] = nums.length, because, this will point it to be back
        // 4. (prev + nums[i] + len) %len ==> for moving around the array

        if (nums == null || nums.length < 2) return false;  // default cases
        int len = nums.length; // think of [0,9] and modular 10
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) continue;

            // mark as visited for i
            int nextIdx = (i + nums[i] + len) % len;  // curIndex and # of steps to move forward/backward
            if (nextIdx == i) continue; // skip given a loop needs to be more than 1 element

            // start exploring now
            int curIdx = i;
            while (nums[curIdx] * nums[nextIdx] > 0) { // same direction
                nums[curIdx] = 0; //  mark as visited s.t if visited again, nums[nextIdx] = 0, which breaks out of the while-loop
                // update curIdx and nextIdx
                curIdx = nextIdx;
                // update nextIdx
                nextIdx = (curIdx + nums[curIdx] + len) % len;
                if (nextIdx == i) {
                    return true;
                }
            }
        }
        // not found
        return false;
    }
}
