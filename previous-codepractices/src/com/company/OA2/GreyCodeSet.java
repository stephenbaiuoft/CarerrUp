package com.company.OA2;

import java.util.*;

/**
 * Created by stephen on 1/11/17.
 */

// Leetcode 89
//https://leetcode.com/problems/gray-code/

// return an array of grey code given n
public class GreyCodeSet {
    public GreyCodeSet(){

        //getGreyCode(3);
        LGreyCode(3);
    }

    public List<Integer> LGreyCode(int n ){

        List<Integer> mList = new LinkedList<>();
        if (n == 0 ) {
            mList.add(0);
            return mList;
        }
        mList.add(0);
        mList.add(1);
        int count = 2;
        while( count <= n){
            int add = 1 << (count - 1);
            int temp ;
            for( int i = add - 1 ; i >= 0; i --){
                temp = add + mList.get( i );
                mList.add( temp);
            }
            count ++;
        }

        //System.out.print(     Arrays.deepToString( mList.toArray() ));
        return mList;

    }

    // this returns in[]
    public int[] getGreyCode(int n ){
        if ( n == 0) return new int[] {0};
        // we know max size anyway
        int space = (int)Math.pow(2, n);

        int [] ary = new int[ space ];
        ary[0]  = 0 ;
        ary[1]  = 1;

        int count = 2;
        int i ;
        int index = 2;
        while( count <= n ){
            i = count;
            int iter = ((int) Math.pow(2,i-1) ) - 1;
            int add = 1 << (i-1);
            while( iter >= 0){
                ary[index] = ary[iter] + add;
                index++;
                iter--;
            }
            count ++;
        }

        for(int t = 0; t < ary.length; t++){
            System.out.print(ary[t]);
        }
        return ary;
    }

}
