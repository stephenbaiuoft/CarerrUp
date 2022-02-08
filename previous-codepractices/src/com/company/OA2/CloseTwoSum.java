package com.company.OA2;

import java.util.Arrays;

/**
 * Created by stephen on 1/7/17.
 */

//
// http://www.jianshu.com/p/e7c3d48b7934


class Container {
    public double first;
    public double second;
}


public class CloseTwoSum {

    public CloseTwoSum(){

        double capacity = 39;
        double[] weights = {10,24,30,9,19,23,7};
        Container result = getContainer(weights, capacity);
        System.out.print(result.first + "   " + result.second);

    }

    public Container getContainer( double[] weights, double capacity){
        // greedy solution, sort array, and match min with max
        Arrays.sort(weights);
        int i = 0 ;
        int j = weights.length - 1;
        Container res = new Container();

        double Cmin = 0;
        double Cmax = 0;
        double Cweight = 0;

        while(  i < j ){


            if ( (weights[i] + weights[j] ) < capacity){
                if  (( weights[i] + weights[j] ) > Cweight ){
                    Cmin = weights[i];
                    Cmax = weights[j];
                }
                i = i + 1;

            }else if ((weights[i] + weights[j] ) == capacity){
                   res.first = weights[i];
                   res.second = weights[j];
                   return res;
            }else{
                j = j - 1;
            }

        }

        res.first = Cmin;
        res.second = Cmax;
        return res;
    }
}
