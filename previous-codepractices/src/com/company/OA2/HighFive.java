package com.company.OA2;

import java.util.*;

/**
 * Created by stephen on 1/12/17.
 */
//https://segmentfault.com/a/1190000007065492
/*
* 写好了一个叫Result的类，中文翻译成节点，题目是输入是一堆节点，
* 节点里面有两个属性学生id和分数，保证每个学生至少会有5个分数，求每个人最高的5个分数的平均分。
* 返回的是Map<Integer, Double>, key是id，value是每个人最高5个分数的平均分double是平均分。
* */

class Result{
    int id;
    int value;
    public Result(int id, int value){
        this.id = id;
        this.value = value;
    }
}


class studentGrade{

    // keep track of top store
    private Queue<Integer> mHeap;

    public studentGrade(int value){
        // Min Heap works already
        mHeap = new PriorityQueue<Integer>();
        mHeap.add(value);

    }

    public void add( int value){
        if (mHeap.size() < 5){
            mHeap.add(value);
        }
        else{
            if (value >  mHeap.peek() ){
                mHeap.poll();
                mHeap.add(value);
            }
        }
    }

    // return MaxAvg for a student, or -1 if there are
    // < 5 marks
    public double getMaxAvg(){
        if( mHeap.size() < 5){
            return -1.0;
        }
        int sum = 0 ;
        for ( int m : mHeap){
            sum += m;
        }

        // return double size
        return (double) sum/ mHeap.size();
    }
}

public class HighFive {
    public HighFive(){
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);

    }


    public Map <Integer, Double> getHighFive( Result[] mInput){
        // Hash for int and
        HashMap< Integer , studentGrade> mSystem = new HashMap<>();

        for ( Result rez: mInput){
            if ( mSystem.get(rez.id) != null){
                // add the value to the system
                studentGrade cur = mSystem.get(rez.id);
                cur.add(rez.value);

            }else{
                mSystem.put(rez.id, new studentGrade(rez.value));

            }
        }

        for ( int key: mSystem.keySet()){
            // note -1 might be printed
            System.out.println(
                    "student id: " + key + "    "
                            +"  Max Mark is: " + mSystem.get(key).getMaxAvg()
            );
        }

        return (Map) mSystem;
    }

}
