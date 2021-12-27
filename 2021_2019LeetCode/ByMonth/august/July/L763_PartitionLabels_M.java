package ByMonth.august.July;

import java.util.ArrayList;
import java.util.List;

public class L763_PartitionLabels_M {
    public L763_PartitionLabels_M() {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> rez = partitionLabels(s);

    }

    // beats 94.5% of the solution
    public List<Integer> partitionLabelsSol(String S) {
        List<Integer> l = new ArrayList<>();
        if (S == null || S.length() < 1) return l;
        // map to record last index of each character
        int[] map = new int[26];
        for(int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }

        // mark start and end
        int start = 0, maxIndex = 0;

        for(int i = 0; i < S.length(); i++) {
            // get the maxIndex for each character
            maxIndex = Math.max(maxIndex, map[S.charAt(i)-'a']);
            // if this already is the last one, then we may safely add
            // to the list
            if (maxIndex == i) {
                l.add(i - start + 1);
                // update start
                start = i + 1;
            }
        }

        return l;

    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> l = new ArrayList<>();
        if (S == null || S.length() < 1) return l;

        // mark start and end
        int s = 0;
        int e = 0;
        int maxIndex = 0;
        int n = S.length();

        while (e < S.length()) {
            // get the new coming character
            char c = S.charAt(e);
            int lindex = S.lastIndexOf(c);
            // if its lindex is itself & no repeats
            if (lindex == e && (e == maxIndex)) {
                // add the # of characters for this
                l.add(lindex - s + 1);
                // update the starting index & the maxIndex value!!
                // by default, the min possible would be e+1 (of its own lastIndex)
                s = e+1;
                maxIndex = e+1;
            } else {
                // lindex > e or lindex < e [smaller should not happen]
                if (maxIndex < lindex) {
                    maxIndex = lindex;
                }
            }

            // move to next character
            e +=1;
        }

        return l;

    }

}
