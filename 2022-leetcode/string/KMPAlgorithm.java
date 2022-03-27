package string;

import java.util.LinkedList;
import java.util.List;

// Test here: https://leetcode.com/problems/implement-strstr/
public class KMPAlgorithm {
    // nextTable
    // max len of prefix && suffix for an index i, substring [0, i) not including i
    // note prefix, suffix cannot be the substring itself

    // nextTable construct
    // similar logic
    // -> nextTable[i + 1] = j 因为nextTable加入新的element 在i这个index 其实是i+1
    public static void main(String[] args) {
        KMPAlgorithm kmp = new KMPAlgorithm();
        kmp.subStr("aaaaa", "bba");
    }

    // Given s and prefix p, find matching indices
    public List<Integer> subStr(String s, String p) {
        int[] nextTable = buildNextTable(p);
        List<Integer> answer = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
           while (j > 0 && s.charAt(i) != p.charAt(j)) {
               // update index j go to back
               j = nextTable[j];
           }
           if (s.charAt(i) == p.charAt(j)) {
               j+=1;
           }

           // Found one
           if (j == p.length()) {
               // i at end of match right now
               answer.add(i - j + 1);
               // update j
               j = nextTable[j];
           }
        }

        return answer;
    }

    // Given prefix, build it's nextTable, failTable
    public int[] buildNextTable(String prefix) {
        // nextTable is prefix.length() + 1 as index of j needs to route back to the starting index
        int[] nextTable = new int[prefix.length() + 1];
        // initial values are [0, 0]
        // 这相当于错开 就是
        // p [A, A, B, A]               i = 1
        // p    [A, A, B, A]            j = 0开始比较来做这个nextTable

        int j = 0;
        for (int i = 1; i < prefix.length(); i++) {
            while (j > 0 && prefix.charAt(i) != prefix.charAt(j)) {
                j = nextTable[j];
            }

            if (prefix.charAt(i) == prefix.charAt(j)) {
                j += 1;
            }
            // note for nextTable -> i+1 is the actual one to be inserted
            nextTable[i + 1] = j;
        }
        return nextTable;
    }

}
