package string_processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// example --> "cbacdcbc" 这个解法有问题
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
