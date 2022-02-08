package Leetcode;

import java.util.*;


public class L247_M {
    public List<String> findStrobogrammatic(int n) {

        List<String> n1 = new LinkedList<>(Arrays.asList( "0", "1", "8")) ;
        List<String> n2= new LinkedList<>(Arrays.asList("11", "69", "88", "96"));

        if (n < 3) return  n == 1 ? n1 : n2;
        LinkedList<String> result = null;

        if (n % 2 == 0) {
            result = getBaseList(n);
        } else {
            result = getBaseList(n - 1);
            int l = result.size();
            component1(n1, result, l);

        }
        return (List<String>) result;

    }

    private void component1(List<String> n1, LinkedList<String> result, int l) {
        for(int i = 0; i < l; i++) {
            String s = result.poll();
            int hEnd = s.length()/2;
            for(int j = 0; j < n1.size(); j++) {
                result.add(s.substring(0, hEnd) + n1.get(j) + s.substring(hEnd));
            }
        }
    }

    // get the baseList for n as an even number
    public LinkedList<String> getBaseList(int n ) {
        LinkedList<String> base = new LinkedList<>(Arrays.asList("11", "69", "88", "96"));
        List<String> n2= new LinkedList<>(Arrays.asList("00","11", "69", "88", "96"));
        for(int i = 2; i < n; i+= 2) {
            int l = base.size();
            component1(n2, base, l);
        }

        return base;

    }

}
