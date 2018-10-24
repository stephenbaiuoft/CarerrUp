package Leetcode;
/*
*   S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

    S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted.
    More specifically, if x occurs before y in S, then x should occur before y in the returned testing.string.

    Return any permutation of T (as a testing.string) that satisfies this property.

    Example :
    Input:
    S = "cba"
    T = "abcd"
    Output: "cbad"
    Explanation:
    "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
    Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.


    Note:

    S has length at most 26, and no character is repeated in S.
    T has length at most 200.
    S and T consist of lowercase letters only.
* */
public class L791_M {
    public String customSortString(String S, String T) {
        int[] Tmap = new int[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (S.indexOf(c) > -1 ) {
                Tmap[c - 'a'] ++;

            } else {
                sb.append(c);
            }
        }

        for (int i = S.length() - 1; i > -1 ; i--) {
            char c = S.charAt(i);

            while (Tmap[c - 'a'] -- > 0) {
                sb.insert(0, c);
            }
        }

        return sb.toString();
    }
}
