package com.company.sortAlgorithm;

import java.util.Scanner;

/**
 * Created by stephenbai on 2016-10-22.
 */
/*
*       bubblesort test = new bubblesort();
        bubblesort.sort("3 1 2 3");
* */
public class bubblesort {

    public static void sort( String input){
        Scanner parse = new Scanner(input);
        int n = parse.nextInt();

        // int [] myArray = new int[3];
        // dynamic is the ArrayList
        int [] myArray = new int[n];
        for(int i = 0; i < n; i++){
            myArray[i] = parse.nextInt();
        }

        int totalSum = 0;
        int hold = 0;
        for (int i = 0; i< n; i++){
            int swap = 0;
            for (int j =0; j< n - 1; j++){
                if (myArray[j]> myArray[j+1]){
                    hold = myArray[j+1];
                    myArray[j+1] = myArray[j];
                    myArray[j] = hold;
                    swap++;
                }

            }
            totalSum += swap;
        }
        System.out.println("number of swap total: " + totalSum);

        // make array
    }
}
