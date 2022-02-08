package com.company.november;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stephenbai on 2016-11-11.
 */
public class PriorityQueueOrder {
    PriorityQueue<mObject> mDefault = new PriorityQueue<>();
    PriorityQueue<mObject> mModify =
            new PriorityQueue<>(new mComparator());

    public PriorityQueueOrder(){
        int j = 100;
        for (int i =10; i < 20; i ++){
            mDefault.add(new mObject(i,j-i));
            mModify.add(new mObject(i,j-i));
        }
        // set debugger and see value

    }

}

class mComparator implements Comparator<mObject>{
    public int compare(mObject o1, mObject o2){
        // id first top will be 19, 18, 17........
        return o2.id - o1.id;
    }
}

class mObject implements Comparable<mObject>{
        public int id;
        public int data;
    public mObject(int id, int data){
        this.id = id;
        this.data = data;
    }

    public int compareTo(mObject other){
        // default this.id - other.id
        // in ascending order
        return this.id - other.id;
    }

}