package string_processing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class L809_ExpressiveWords_M {
    public L809_ExpressiveWords_M() {
        int c = expressiveWords("aaa",
                new String[] {"aaaa"});
    }

    public int expressiveWords(String S, String[] words) {
        StringPattern sP = new StringPattern(S);
        int sum = 0;
        for (String w: words) {
            StringPattern wP = new StringPattern(w);
            if (sP.equals(wP)) {
                sum++;
            }
        }

        return sum;
    }

    class StringPattern {
        public ArrayList<Integer> countSet = new ArrayList<>();
        public String key = "";

        public StringPattern(String s) {
            // last index that is different from the current index
            StringBuilder sb = new StringBuilder();
            int lastIdx = -1;
            for (int i = 0; i < s.length(); i++) {
                // need to update countSet && charSet
                if (i == s.length()-1 || s.charAt(i+1) != s.charAt(i)) {
                    countSet.add(i - lastIdx);
                    // update last index as i, because s.charAt(i) != s.charAt(i+1)
                    lastIdx = i;
                    sb.append(s.charAt(i));
                }
            }
            key = sb.toString();
        }

        public boolean equals(StringPattern w) {
            // charSet comparison first
            if (!key.equals(w.key))
                return false;

            // use current as the String S
            for (int i = 0; i < countSet.size(); i++) {
                // given here, charSet order is identical the w's charSet order

                int c1 = countSet.get(i);
                int c2 = w.countSet.get(i);
                //这个条件好tm重要啊

                // case1: "aa"  vs "aaa" false   c1 < c2
                // case2: "aa" vs "a" false c1 < 3 && c1 > c2
                // case3: "aaa" vs "aa" or "a" ==> true   --> this is the else statement
                if ((c1 < 3 && c1 > c2) || c1 < c2 ) {
                    return false;
                }
            }
            // final base case
            return true;
        }
    }

}
