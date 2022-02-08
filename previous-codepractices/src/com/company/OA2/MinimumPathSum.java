package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */
//Leetcode 64
// given a matrix, either go down or right, find its minimum path sum
public class MinimumPathSum {
    public MinimumPathSum(){

    }

    public int minPath(int[][]grid){
        if ((grid==null))
        {return 0;}

        int gRow = grid.length ;
        int gCol = grid[0].length;

        int[] D = new int[gCol];
        // initialize 1-D Array to hold temporary variables
        for ( int i = 1 ; i < gCol ; i ++){
            D[i] = Integer.MAX_VALUE;
        }

        if (gCol !=1){
            D[0] = 0;
            for(int i = 0 ; i < gRow; i ++){
                D[0] = grid[i ][0] + D[0];

                for(int j = 1; j < gCol; j++) {
                    D[j] = Math.min(D[j], D[j - 1])
                            + grid[i ][j];
                }
            }
        return D[gCol-1];
        }
        else{
            int sum = 0;
            for (int i = 0 ; i < gRow; i++){
                sum += grid[i][0];
            }
            return sum;
        }
    }

}



