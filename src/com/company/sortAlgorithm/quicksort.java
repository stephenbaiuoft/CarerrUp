package com.company.sortAlgorithm;

import java.util.Scanner;

/**
 * Created by stephenbai on 2016-10-24.
 */
public class quicksort {

    static int partitionSolution(int[] ary, int start, int end){
        int i = start - 1;
        int pivot = ary[end];
        for (int j = start; j < end; j++){
            if (ary[j] <=pivot){
                i++;
                // you are swapping j with i!! and (after incrementing)
                // i denotes the furthest smallest element
                swapSolution(ary, j, i);
            }
        }

        swapSolution(ary, i + 1, end);
        return i + 1;
    }

    static void swapSolution(int[] ary, int largeIndex, int smallIndex){
        if ( largeIndex!= smallIndex){

        int tmp = ary[largeIndex];
        ary[largeIndex ] = ary[smallIndex];
        ary[smallIndex] = tmp ;
        }
    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void qsort(int[] ary, int p, int r){
        if ( p < r){

            int q = partitionSolution(ary, p, r);
            // print partitioned ary at each iteration
            printArray(ary);
         qsort(ary, p , q - 1 );
         qsort(ary, q+1, r);
        }
    }

    public static void run( String args) {
        Scanner in = new Scanner( args );
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        qsort( ar, 0, ar.length - 1 );
    }


// pivot is chosen as first element as required
    public static void partitionHacker(int[] ary){
        int pivot = ary[0];
        int i = 0 ;

        // j skips first and swap later on
        for(int j = 1; j < ary.length ; j ++){
            if ( ary[j] <= pivot ){
                i++;
                swapSolution(ary, i, j);
            }
        }
        // since every smaller up to ith point, simply swap 0 and i
        swapSolution(ary, 0, i );


    }
}
