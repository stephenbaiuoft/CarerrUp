//asdkjflkadjka

package com.company.javaClass;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/**
 * Created by stephenbai on 2016-11-11.
 */

//Iterator fail-fast
//Enumerator not fail-fast
public class VectorORArrayList {
    // default run
    public VectorORArrayList(){
        main();
    }

    public void main(){
        vector();
    }

    // 1.non-threadsafe 2. faster 3. arraylist meet max, 50% growth
    // 4. default/unchangable incremental size
    // 5. only Iterator
    public void arrayList(){

    }
    // 1. thread-safe 2. slow 3. vector meets max, double
    // 4. changable incremental size
    // 5. both Iterator and Enumerator
    public void vector(){
        Vector<mObject> v1 = new Vector<>();
        int sId= 10;
        int sScore = 100;
        int sOther = 1000;
        for (int i =0; i< sId; i++){
            v1.add( new mObject(i, sScore + i,
                    sOther + i));
            v1.add( new mObject(i, sScore + i,
                    sOther + i));
        }

        Collections.sort(v1);

        for (int i = 0; i < sId; i++){
          System.out.print (v1.get(i).id+"\t");
        }

        System.out.println();

        v1.sort( new mComparator() );
        for (int i = 0; i < sId; i++){
            System.out.print (v1.get(i).id+"\t");
        }
    }

    class mObject implements  Comparable<mObject>{
        public int id;
        public int score;
        public int other;
        public mObject(int id, int score, int other){
            this.id = id;
            this.score = score;
            this.other = other;
        }
        public int compareTo(mObject other){
            // ascending order    small - > large
            return other.id - id;
        }


    }

    //
    class mComparator implements Comparator< mObject>{
        public int compare( mObject o1, mObject o2){
            //descending
            return o2.other - o1.other;
        }
    }
}
