package feb22prep.thirty;

import java.util.*;

public class L394_DS_M {
    public static void main(String[] args) {
    }

    /**
     * Stack + HashMap so that you can record [ index with ] index for all [] pairs
     * - build the map
     *
     * Next
     * - decode recursion
     *  - First sIndex, and eIndex, (all inclusive or eIndex not inclusive? your condition will vary too
     *   - Inclusive as what's what came to my mind
     *  - Second
     *   - when iterate from sIndex to eIndex
     *    - YOU HAVE TO UPDATE i!!!!!!
     *
     * Input: s = "3[a]2[bc]"
     * Output: "aaabcbc"
     */
    public String decodeString(String s) {
        // store the { indices,
        Stack<Integer> stack = new Stack<>();
        // store index {, the index for }
        HashMap<Integer, Integer> map = new HashMap<>();

        // build the map
        char[] sa = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (sa[i] == '[') {
                stack.push(i);
            } else if (sa[i] == ']') { // found the first match
                int lIndex = stack.pop();
                // so
                map.put(lIndex, i);
            }
        }


        return decode(sa, 0, s.length() -1, map);
    }

    // Compute the String between sIndex, and eIndex
    public String decode(char[] sa, int sIndex, int eIndex, Map<Integer, Integer> map) {
        // Done, return
        if (sIndex > eIndex) return "";
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = sIndex; i <= eIndex; i++) {
            if (Character.isDigit(sa[i])) {
                // update count
                count = count * 10 + sa[i] - '0';
            } else { // this is where the computation happens
                if (sa[i] == '[') {
                    // Recursion to get the string within {xxxx}
                    String str = decode(sa, i+1, map.get(i)-1, map);
                    while (count > 0) { // Add to stringbuilder
                        sb.append(str);
                        count --;
                    }
                    // Update the i, to } index, and the next iteration will add 1
                    i = map.get(i);
                } else {
                    // Add to sb
                    sb.append(sa[i]);
                }
            }
        }

        return sb.toString();
    }


}
