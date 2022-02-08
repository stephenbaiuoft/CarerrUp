package com.company.sortAlgorithm;

/**
 * Created by stephenbai on 2016-11-08.
 */
// helps verify things
public class HelperTool {

    public boolean verifySorted(int[] ary){
        for (int i = 0; i+1 < ary.length - 1; i++){
            if (ary[i]> ary[i+1]){
                return false;
            }
        }
        return true;
    }

}
