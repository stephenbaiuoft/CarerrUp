package Codebase.stringrelated;

import java.util.ArrayList;
import java.util.List;

public class L623_KEditDistance_M {

    class TrieNode {
        // Initialize your data structure here.
        public TrieNode[] children = new TrieNode[26];
        public boolean hasWord = false;
        public String curString;

    }

    // Adds a word into the data structure.
    public void insert(TrieNode head, String word) {
        TrieNode curNode = head;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (curNode.children[c - 'a'] == null) {
                curNode.children[c - 'a'] = new TrieNode();
            }
            curNode = curNode.children[c - 'a'];
        }
        curNode.curString = word;
        curNode.hasWord = true;

    }

    private TrieNode head = new TrieNode();
    public List<String> kDistance(String[] words, String target, int k) {
        for (int i = 0; i < words.length; i++)
            insert(this.head, words[i]);

        List<String> rez = new ArrayList<String>();

        int[] dp = new int[target.length() + 1];
        // worst case -> modify use update for each trieNode for now so you need 0,1,...n
        for (int i = 1; i <= target.length(); ++i)
            dp[i] = i;

        find(this.head, rez, k, target, dp);
        return rez;
    }

    public void find(TrieNode node, List<String> result, int k, String target, int[] dp) {
        int n = target.length();
        if (node.hasWord && dp[n] <= k) {
            result.add(node.curString);
        }

        int[] updateDp = new int[target.length() + 1];

        for (int i = 0; i < 26; ++i)
            // for every possible exploration --> we check with updated new dp to track # of min modifications
            if (node.children[i] != null) {
                updateDp[0] = dp[0] + 1; // the updateDp so far to reach the current starting node
                for (int j = 1; j <= n; j++) { //
                    if (target.charAt(j - 1) - 'a' == i) {
                        // equal, meaning no need to modify so equal to dp[j-1]
                        //   or if the previous index is smaller with updateDp remove/add to match the current character
                        updateDp[j] = Math.min(dp[j - 1], Math.min(updateDp[j - 1], dp[j]) + 1);
                    } else {
                        // not equal, so both need to increment by 1 modification
                        updateDp[j] = Math.min(dp[j - 1] , Math.min(updateDp[j - 1], dp[j]) );
                        updateDp[j] += 1;
                    }
                }
                find(node.children[i], result, k, target, updateDp);
            }
    }
}
