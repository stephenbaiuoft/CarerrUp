package bfs.or.dfs;

import java.util.HashMap;
import java.util.HashSet;
/*
* https://www.interviewbit.com/problems/colorful-number/
* */

public class ColorfulNumber {
    public ColorfulNumber() {
        colorful(123);
    }

    public int colorful(int A) {
        HashSet<Integer> H = new HashSet<Integer>();
        int len = Integer.toString(A).length();
        int[] n = new int[len];

        if (len == 1) return 1;

        for(int i = 0; i<len; i++) {
            n[i] = A%10;
            A = A/10;
        }

        for(int i = 0; i<len; i++) {

            int tmp = 1;
            for (int j = i; j<len; j++) {
                tmp *= n[j];
                if(H.contains(tmp)) return 0;
                else H.add(tmp);
            }
        }

        return 1;
    }


}
