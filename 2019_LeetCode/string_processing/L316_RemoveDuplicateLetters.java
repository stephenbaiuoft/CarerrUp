package string_processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
* Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"
Example 2:

Input: "cbacdcbc"
Output: "acdb"
* */


/* 思路
* ## You find the smallest character to add by the following rule
#r0: create a hashmap that stores the indexes of occurences for each character in order
#r1: the smallest possbile character, with its first index 'i_smallest' of occurence being smallest than all other characters
#r2. add this character and for all other characters, remove their occurence indexes that are smaller than 'i_smallest'
#r3. continue until you have loop through all the possible characters.

## Explaination / Why it works
say you start with the smallest character c1, with iC1Left being the first index (use left to denote it's the first element) of occurence, now there are only two cases:
* case 1:  there exists some larger character c2, with its index of iC2Right larger than iC1Left, in this case, we may safely ignore because lexigraphically, this c2 would be added later on

* case 2: there  exists some larger character c2, with its index of iC2Right smaller than iC1Left, in this case, we CANNOT add c1, because lexigraphically, having c2 in front of c1 is correct.
* case2.1: so we leave out c1, and find the next smaller character that meets our rule.
* case2.2 When we found such a c1 character, then, all the other characters with indices smaller than iC1Left, should be taken out. This is because having such a c1 means that all the characters with indexes smaller than iC1Left are strictly smaller than c1.

* */
public class L316_RemoveDuplicateLetters {
    public L316_RemoveDuplicateLetters() {
        String s = "cbacdcbc";
        String rez = removeDuplicateLetters(s);
    }

    public String removeDuplicateLetters(String s) {
        // no duplicates possible
        if ( s == null || s.length() <=1) return s;
        StringBuilder sb = new StringBuilder();
        // [0,25] for [a,z]
        ArrayList<Integer>[] map = new ArrayList[26];
        char[] cMap = new char[s.length()];
        int cIdx = ' ';
        for (int i = 0; i < s.length(); i++) {
            cIdx = s.charAt(i) - 'a';
            if (map[cIdx] == null ){
                map[cIdx] = new ArrayList<>();
            }
            // add it correspondingly
            map[cIdx].add(i);
        }

        // minCharIdx and minPosIdx
        int minCharIdx = 0;
        int minPos = 0;
        while (minCharIdx < 26) {
            // not the minCharIdx, continue
            if (map[minCharIdx] == null) {
                minCharIdx++;
            }
            // smallest character, also smallest minPos
            else {
                // get the minPos for the minCharacter
                int minPosForMinChar = 0;
                for (int i = minCharIdx; i < 26; i++) {
                    if (map[i] == null) continue; // skip null entries

                    // get the first entry, compare it against right most idxes
                    minPosForMinChar = map[i].get(0);
                    boolean smallest = true;
                    for (int j = i+1; j < 26; j++) {
                        if (map[j] == null) continue; // skip null entries

                        // get the rightmost for others
                        if (map[j].get(map[j].size()-1) < minPosForMinChar) {
                            smallest = false;
                            break;
                        }
                    }
                    if (smallest) {
                        // clean this map
                        map[i] = null;
                        minCharIdx = i;
                        break;
                    }
                }

                // put in relative position for cMap
                char tmp = (char) ('a' + minCharIdx);
                sb.append(tmp);
                // need to remove any larger character ahead of minChar if possible
                for (int j = 0; j < minPosForMinChar; j++) {
                    ArrayList<Integer> l = map[s.charAt(j) - 'a'];
                    while (l != null && l.size() > 1
                            && l.get(0) < minPosForMinChar) {
                        // remove the first element
                        l.remove(0);
                    }
                }
                // start from 0 again
                minCharIdx = 0;
            }
        }

        return sb.toString();
    }

}
