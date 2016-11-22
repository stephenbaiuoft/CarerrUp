package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */
//Leetcode 64
// given a matrix, either go left or right, find its minimum path sum
public class MinimumPathSum {
    public MinimumPathSum(){

    }

    public int minPathSum(int[][]grid){
        if ((grid==null))
        {return 0;}

        int gRow = grid.length - 1;
        int gCol = grid[0].length - 1;

        // initialize the array, 1D to save space
        int[] D = new int[gCol+1];
        D[0] = grid[0][0];
        for(int i = 1; i < gRow; i++){
            // Note update D
            D[0] = D[0] + grid[i][0];
            for(int j = 1; j < gCol; j++) {
               D[j] = Math.min(D[j],D[j-1]) + grid[i-1][j-1];
            }
        }
        return D[gCol -1 ];
    }
/*
*     public int minPathSum(int[][]grid){
        if ((grid==null))
        {return 0;}

        int gRow = grid.length;
        int gCol = grid[0].length;

        int[][] D = new int[gRow+1][gCol+1];
        for(int i = 2; i < gCol+1; i++){
            // first row except first element, every else initialized to max
            D[0][i] = Integer.MAX_VALUE;
        }
        for(int i = 2; i < gRow+1; i++){
            // first col except first, every is initialized to max
            D[i][0] = Integer.MAX_VALUE;
        }
        for(int i = 1; i < gRow+1; i++){
            for(int j = 1; j < gCol+1; j++) {
                D[i][j] = Math.min(D[i-1][j], D[i][j-1]) + grid[i-1][j-1];
            }
        }
        return D[gRow][gCol];
    }
* */
    // bottom up,
    // D[0,0] = grid[0][0] by default
    // D[i,j] is the minimum path for any given point
    // D[i,j] = min( D[i-1,j, D[i, j-1]) + grid[i,j]
}
