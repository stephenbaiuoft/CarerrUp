package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */
public class ArithmaticSequence {
    public ArithmaticSequence(){
        int[] t = {1,2,3,4,5};
        numberofArithMaticSequence(t);
    }
    public int numberofArithMaticSequence(int[]A){
        if (A.length < 3){
            return 0;
        }
        // key is 3 is all required
        int sum = 0;
        int cur = 0;
        for(int i=0; i<A.length-1; i++){
            if ( (A[i] -A[i-1]) ==(A[i+1]-A[i])){
                cur++;
                sum+=cur;
            }
            else{
                //	reset cur
                cur = 0;
            }
        }
        return sum;
    }

    public int fasterNumberofArithMaticSequence(int[]A){
        int sum = 0;
        int aLength = A.length;
        int i = 0;
        while( i < aLength - 2){
            int d = A[i+1] - A[i];
            int count = 2;
            int iEnd = i + 2;
            // go through this list
            while((iEnd < aLength)&&( A[iEnd] - A[iEnd -1 ] == d)){
                count++;
                iEnd++;
            }
            if(count>2){
                sum += (count-2)*(count-1)/2;
                i = iEnd - 1;
            }else{
                i++;
            }
        }
        return sum;
    }
}
