package com.company.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by stephenbai on 2016-11-17.
 */

//        int nums[] = {1, -1};
//  SlidingWindow mTest = new SlidingWindow(nums,1);
public class SlidingWindow {
    public SlidingWindow(int[] nums, int k){
        maxSlidingWindow(nums, k);
    }

    // add
    void addDeque( Deque<Integer> mDeque, int num ){
        // 1,2,3, position means largest, 2nd largest, 3rd largest so far
        // so 6,4,2  remember each i<-->i_+1 means content in between does not matter
        while( ! mDeque.isEmpty() && ( mDeque.peekLast() < num) ){
            mDeque.pollLast();
        }
        mDeque.offerLast( num );
    }

    //
    void removeDeque(Deque<Integer> mDeque, int num){
        // only remove when it's int num is @ that value
        if (mDeque.peekFirst()!=null && num ==mDeque.peekFirst() ){
            mDeque.pollFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        if (k==0 || nums.length==0) return nums;
        if(k > nums.length) {
             return null;
        }


        Deque <Integer> mDeque= new ArrayDeque<Integer>();

        for (int i =0; i<k;i++){
            addDeque(mDeque, nums[i]);
        }

        result[0] = mDeque.peekFirst();
        removeDeque(mDeque, nums[0]);
        for (int i = k; i < nums.length; i++){
            addDeque(mDeque, nums[i]);
            result[i-k+1] = mDeque.peekFirst();
            // check left window
            removeDeque(mDeque, nums[i-k+1]);
        }

        System.out.println(
                Arrays.toString(result));

        return result;
    }

}
