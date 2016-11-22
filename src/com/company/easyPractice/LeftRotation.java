package com.company.easyPractice;
import java.util.Scanner;

/**
 * Created by stephenbai on 2016-10-21.
 */
public class LeftRotation {

    public static void run(String args) {
        Scanner in = new Scanner( args );
        int n = in.nextInt();
        int k = in.nextInt();

        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
// n is the size of array, k is left # of shits
        //int [] first = new int[k];
        //int [] second = new int[n-k];
        //src, srcPos, dest, destPos, # of elements to copy
        int [] res = new int[n];

        //System.arraycopy(a, 0, first, 0, k);

        System.arraycopy(a, k, res, 0, n-k);
        System.arraycopy(a, 0, res, n-k, k);

        for (int i =0; i <n ; i ++){
            System.out.println( res[i] );
        }


    }

}
