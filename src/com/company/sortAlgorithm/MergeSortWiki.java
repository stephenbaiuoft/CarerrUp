package com.company.sortAlgorithm;

import java.io.IOError;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by stephenbai on 2016-11-08.
 */
public class MergeSortWiki {
    // space to store temp
    public int[] localTemp;
    public int countSwap = 0;

    // only takes input and prints
    public void sort(String input ){
    Scanner in = new Scanner(input);
    int t = in.nextInt();
    for(int a0 = 0; a0 < t; a0++)
    {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            try {
                arr[arr_i] = in.nextInt();
            }
            catch (IOError ie){
                System.out.println("arr_i is"+ arr_i);
                ie.printStackTrace();;
            }
            finally {
                //System.out.println("arr_i is"+ arr_i);
            }
            }
      //  localTemp = Arrays.copyOf(arr, arr.length);
        mergeSort( arr, 0, arr.length - 1);
        // get arr content

        if (verifySorted(arr)){
        System.out.println(Arrays.toString(arr));
            System.out.println("num of swap is: "+ countSwap);
            }
        else{
            System.out.println("ary is not sorted!!!");
        }
        }

    }


    public boolean verifySorted(int[] ary){
        for (int i = 0; i+1 < ary.length - 1; i++){
            if (ary[i]> ary[i+1]){
                return false;
            }
        }
        return true;
    }

    public void mergeSort(int[] arr, int begin, int end){
        if (begin < end){
            int middle = begin  + (end - begin) / 2;
            // go left mergeSort
            mergeSort(arr, begin, middle);
            // go right mergeSort
            mergeSort(arr, middle+1, end);
            // then merge splitted arrays together
            mergeSplits(arr, begin, middle, end);
        }

    }


//  <32,45> <2,78>, i points to 32, j points to 2 and we always compare latest two elements of two arrays; advances the index with smaller value,
    // k is updated every time
    public void mergeSplits(int[] arr, int begin, int middle, int end){
        // k points to the begin of the original array
        // i is used in localTemp
        int i = begin;
        int k = begin;
        // j is the first of 2nd array
        int j = middle + 1;

        // copy all given elements
        this.localTemp = Arrays.copyOf(arr, end + 1 );

        for ( k = begin; k <= end; k++){
            // see its interesting as java will just run first and go into if statement...
            // once 1 is valid then, sub-statements do not matter
            if ((j > end)||((localTemp[i]<=localTemp[j])
                    &&(i<=middle) )
                    ){
                arr[k] = localTemp[i];
                i++;
            }else{
                arr[k] = localTemp[j];
                j++;
            }
        }

        /*while (( i<=middle ) && (j<=end)){
            if (localTemp[i] <= localTemp[j] ){
                arr[k] = localTemp[i];
                i++;
            }else{
                arr[k] = localTemp[j];
                j++;
            }
            k++;
        }

        countSwap = countSwap + k ;
        // either i or j may break the while loop, meaning one array runs empty now
        if (i > middle){
            // copy existing j now
            while (j<= end){
                arr[ k ] = localTemp[j];
                j++;
                k++;
            }
        }else{
            while(i<=middle){
                arr[k] = localTemp[i];
                i++;
                k++;
            }
        }*/
    }

}
