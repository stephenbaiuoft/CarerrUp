package com.company.november;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stephenbai on 2016-11-11.
 */
public class FindMedian {
// Priority Queue: default largest is always first element
// Note sort is always in Ascending Order this - object....whatever/ or compare?
    //Left-> First is the largest
    PriorityQueue <Integer> leftQueue = new PriorityQueue<>(Comparator.reverseOrder());

    //Right-> First is the smallest among Heap
    PriorityQueue <Integer> rightQueue
            = new PriorityQueue<>( );

    public void addNum(int num){
        // step 1 insert
        if (leftQueue.isEmpty()){
            leftQueue.add( num );
        }

        // add to right if num greater than left
        else if ( num > leftQueue.peek()){
            rightQueue.add(num);
        }
        // add to left Queue
        else if ( rightQueue.isEmpty() || (num <= rightQueue.peek()) ){
            leftQueue.add(num);
        }
        // step 2 balance two heaps sizes
        // left has 2 more
        if (leftQueue.size() - rightQueue.size()
                > 1 ){
            // remove head of leftQueue and insert into right
            rightQueue.add( leftQueue.poll());
        }
        else if (rightQueue.size() - leftQueue.size()
                > 1){
            leftQueue.add( rightQueue.poll());
        }

    }

    // print median
    public void findMedian(){
        //
        if ( leftQueue.size() > rightQueue.size() ){
           System.out.println( leftQueue.peek() );
        }

        else if (rightQueue.size() > leftQueue.size()){
            System.out.println( rightQueue.peek() );
        }
        else{
            int median = leftQueue.peek() + rightQueue.peek();
            double dMedian = (double) median / 2.0;
            System.out.println(dMedian);
        }
    }
}
