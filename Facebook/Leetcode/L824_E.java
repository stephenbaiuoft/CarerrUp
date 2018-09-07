package Leetcode;

import java.util.*;

public class L824_E {
    public String toGoatLatin(String S) {
        if (S == null || S.length() < 1 ) return S;
        String aBase = "a";
        HashSet<Character> vSet = new HashSet<>(Arrays.asList('a', 'e', 'i','o','u',
                'A', 'E', 'I', 'O','U'
        ));
        StringBuilder sb = new StringBuilder();
        String[] set = S.split(" ");


        for (int i = 0; i < set.length; i++) {
            if (vSet.contains(set[i].charAt(0))){
                sb.append(set[i]);
            }
            else {
                sb.append(set[i].substring(1)).append(set[i].charAt(0));
            }
            sb.append("ma").append(aBase).append(" ");
            aBase += "a";
        }

        return sb.toString().trim();
    }
}
