package com.company.november;

import java.util.Scanner;

/**
 * Created by stephenbai on 2016-11-10.
 */
public class ArrayQuery {
    public void solution(String input){
        Scanner scan = new Scanner(input);
        // m is total # of elements
        // n is # of query operations
        int m = scan.nextInt();
        int n = scan.nextInt();

        int mAry[] = new int[m];
        for( int i=0; i < m; i++){
            mAry[i] = scan.nextInt();
        }

        int instr = 0;
        int i = 0;
        int j = 0;
        for (int count = 0; count < n; count++){
            instr = scan.nextInt();
            i = scan.nextInt();
            j = scan.nextInt();

        }

    }

    // idea is use array copy? and array merge?
    public void query(int[]input, int choice, int i, int j ){
        if (choice ==1){

        }else if (choice ==2){

        }else{
            System.out.println("should not get here wrong parsing/input?");
        }
    }

}
