package com.company.OA2;

import java.util.HashMap;

/**
 * Created by stephenbai on 2016-11-18.
 */

// http://www.jianshu.com/p/6ba6edd52442

public class TwoSum {
    public TwoSum(int[] nums, int target){
        twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mDic = new HashMap<>();
        int[] result = new int[2];
        for( int i =0; i< nums.length;i++){
            // if contain return
            if(mDic.containsKey(nums[i])){
                result[0] = mDic.get(nums[i]);
                result[1] = i;
                return result;
            }else{
                // put in stuff, remove duplicates
                mDic.put(target - nums[i], i);
            }
        }
        return result;
    }
}
