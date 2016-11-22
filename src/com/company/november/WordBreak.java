package com.company.november;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by stephenbai on 2016-11-11.
 */
public class WordBreak {
    public WordBreak(){
        ArrayList mAry = new ArrayList();
        mAry.add("aaaa");
        mAry.add("aaa");

        System.out.println( wordBreakSolution("aaaaaaa", mAry));
    }
    public boolean wordBreak(String s, ArrayList wordDict) {
        if ((s ==null) || wordDict ==null ) return false;

        int index = 0;
        String substring;
        for (int i = 0; i < s.length(); i++){
            if( i ==0 ){
                substring =String.valueOf( s.charAt(0) );
            }
            else{
                substring = s.substring(index, i + 1);
            }
            if( wordDict.contains(substring) ){
                // update index
                index = i + 1;
            }
        }

        if (index == s.length()) return true;
        return false;

    }

    public boolean wordBreakSolution(String s, ArrayList wordDict){
        int[] pos = new int[s.length()+1];

        // pos records if that index is good ( meaning as long as > -1)
        Arrays.fill(pos, -1);

        pos[0]=0;

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[s.length()]!=-1;
    }
}
