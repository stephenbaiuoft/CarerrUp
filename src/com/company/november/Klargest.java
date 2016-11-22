package com.company.november;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stephenbai on 2016-11-11.
 */
/*
*
*         Klargest mTest = new Klargest();
        int[] ary = {3,2,1,5,6,4};
        mTest.findKthLargest(ary, 2);

        */
// use heaps to store
public class Klargest {
//Either Largest or Smallest using Queue

    // Left -> First is largest within left heap
    PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Comparator.reverseOrder());

    //Right-> First is the smallest among Heap
    PriorityQueue <Integer> rightQueue
            = new PriorityQueue<>( );

    public Klargest(){
        int[] t = {8,3,5,10,23};
        int k = 3;
        findKthLargest(t, k);
    }

    public void findKthLargest(int[] nums, int k){
        //if (nums.length <= 1)

        // kth largest means first (l - k) + 1 from left to right
        int l = nums.length - k + 1;
        for (int i =0; i< nums.length; i++){
            addNum(nums[i], (i+1), l);
        }
        System.out.println(leftQueue.peek());
    }

    public void addNum(int num, int count, int k){
        // always insert, when count is less than k
        if ( count <= k){
            leftQueue.add( num );
        }

        // more than k elements
        else{
            if ( num <= leftQueue.peek()){
                // add num to left and add to right
                leftQueue.add(num);
                // remove left and add to leftQueue
                 rightQueue.add(leftQueue.poll());
            }
            // num > leftQueue
            else{
                rightQueue.add(num);
            }
        }
    }

    // cleaner implementation
    // new implementation
    // lets add to largest queue
    public void addNumNew(int num,  int k){
        // Queue with max @ top
        // always insert, when count is less than k
        if (leftQueue.size() <= k){
            leftQueue.add(num);
        }
        // more nums now
        else{

        }

    }
}
