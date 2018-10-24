package ByMonth.august.June;

import java.util.HashMap;
import java.util.Map;

public class TestSpace {
    public int solution(int[] A, int K, int M) {
        // write your code in Java SE 8
        if (A == null || K < 1 || M > A.length) return -1;

        // check every insertion & whether meetings the K requirement
        // check whether meeting M requirement,

        // O(n^2)

        // create the 1-n group
        int n = A.length;
        boolean[] curA = new boolean[n];
        int rez = 0;

        for(int i = 0; i < n; i++) {
            int cLocation = A[i];
            curA[cLocation - 1] = true;

            // now check continuous condition
            // the location on i+1 day is next to the current location
            if ( i < n - 1) {
                int nLocation = A[i+1];
                // check left neighbor and right neighbor
                if  ( ( (cLocation > 0 && cLocation - 1 != nLocation)|| cLocation == 0)
                        &&( (cLocation < n && cLocation + 1 != nLocation) || cLocation == n) )
                {
                    int m = evaluate(curA, K) ;
                    if (m == M){
                        rez = Math.max(rez, i+1);
                    }
                }
            }

        }

        if (rez == 0) return -1;
        // last out of boundary condition
        return rez == n + 1? n: rez;

    }

    // evaluate the current A and return # of blooms of size K
    public int evaluate(boolean[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = A.length;
        int interval = K + 1;
        int count = 0;

        for(int i = 0; i < n; i++) {
            // bloomed
            if(A[i]) {
                int p = (i + 1) / interval;
                if (map.containsKey(p)) {
                    map.put(p, map.get(p)+1);
                } else {
                    map.put(p, 1) ;
                }
            }
        }

        for(Integer c: map.values()) {
            if(c == K) {
                count++;
            }
        }

        return count;
    }

}

