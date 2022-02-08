package com.company.OA2;

import java.util.Arrays;

/**
 * Created by stephenbai on 2016-11-18.
 */
public class WindowSum {
    public WindowSum(){
        int[] mInput = {1,-2,3,-45,0,100};
        int k = 3;
        getSum( mInput, k);
    }

    public int[] getSum(int[] input, int k ){
        if ((input == null)||(input.length == 0)||(k <= 0)
                ||(input.length - k < 0)){
            return input;
        }
        int[] result = new int[ input.length - k + 1];
        // get first window sum

        for(int i=0; i < k; i++ ){
            result[0] += input[i];
        }
        // start @ second now
        // k = 2, i = 1, then we want sum_0: 0,1  we want 1,2
        for(int i = 1; i < input.length - k + 1; i++){
            result[i] = result[ i-1 ] - input[i - 1 ] + input[i + k - 1];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
