package com.company.SublimeTest;

/**
 * Created by stephen on 1/11/17.
 */
public class SArithmaticSequence {
    public SArithmaticSequence(){
        int[] num = {1,2,3,4,5,9,10,11,12,13,14,15};
        System.out.print ( "\n" + getLAS(num) + "\n" );
    }
    public static int getLAS(int[] A){
// skip corner cases checks
        int dif  ;
        int count = 2;
        int i = 0 ;
        int iEnd;
        int sum = 0 ;


        // i, i + 1 , i + 2
        while( i < A.length - 2){
            iEnd = i + 2;
            dif = A[i + 1 ] - A[i] ;
            while ( ( iEnd < A.length) &&
                    A[iEnd] - A[iEnd -1] == dif ){
                count ++;
                iEnd++;
            }
            if (iEnd >= i + 2){
                int tmp = (count - 2)*(count -1) / 2;
                sum +=  tmp ;
                // reset count and index i
                count = 2;
                i = iEnd -1;
            }
            else{
                i++;
            }
        }

        return sum;
    }
}
