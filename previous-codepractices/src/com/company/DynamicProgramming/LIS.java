package com.company.DynamicProgramming;

/**
 * Created by stephen on 7/17/17.
 */
// longest increasing sequence
// GeeksbyGeeks DP problem

public class LIS {
    private int[] A;
    private int[] L;

    public LIS(int[]A){
        this.A = A;
        System.out.println(getLIS(A.length));
    }

    public int getLIS(int length){
        int[] dp = new int[length];
        dp[0] = 1;

        int maxCount = 1;
        for(int i =1 ; i < length; i++){
            int maxIStep = 0;
            for(int j= 0; j < i; j++ ){
                if(this.A[j] < this.A[i])
                {
                    maxIStep = Math.max(dp[j], maxIStep);
                }
            }
            dp[i] = maxIStep +1;
            maxCount = Math.max(dp[i], maxCount);
        }

        return maxCount;
    }


/*
    public LIS(int[] A){
        this.A = A;
        //creates L for storing particular length
        L = new int[A.length];
        System.out.println(getL(A.length - 1) + "\n\n");

        int maxCount = 0;
        for(int i = 0; i< A.length; i++){
            maxCount = maxCount < L[i]? L[i]: maxCount;
        }
        System.out.println("maxCount is:" + maxCount);
    }

    // memoization
    // given A, gets the longest increasing sequence
    public int getL(int index){
        if(index == 0){

            return 1;
        }
        else{
            // buttom up
            if (L[index] == 0){
                int maxCount = 0;
                for(int j = index -1 ; j > -1 ; j--){
                    if(maxCount < getL(j) &&this.A[j]<this.A[index]  ){
                        maxCount = getL(j);
                        L[index] = 1+ maxCount;
                    }
                }
                if (L[index] == 0) {
                    L[index] = 1;
                    return 1;
                }else{
                    return L[index];
                }
            }
            else{
                return L[index];
            }

        }
    }
*/
}
