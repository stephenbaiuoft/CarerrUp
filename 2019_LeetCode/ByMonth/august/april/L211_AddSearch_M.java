package ByMonth.august.april;

public class L211_AddSearch_M {
    class TrieNode {
        boolean isWord = false;
        TrieNode [] children = new TrieNode[26];
    }

    private TrieNode root = null;

    /** Initialize your data structure here. */
//    public WordDictionary() {
//        // initialize thhe root by giving it an empty TrieTree
//        root = new TrieNode();
//    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;

        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            // get to the next TrieNode node
            cur = cur.children[index];
        }
        // reached end of the word and mark cur.isWord as True
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(root == null) return false;

        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int k, TrieNode node) {
        // base case
        if (k == word.length() ) return node.isWord;
        // else
        char c = word.charAt(k);
        // sortalgo
        if (c == '.') {
            for(int i = 0; i <26; i++) {
                // note this sortalgo
                // True will ONLY be returned iff all the rest of sortalgo returns True!!!!
                if (node.children[i] != null && searchHelper(word, k+1, node.children[i])) {
                    return true;
                }
            }
        } else {
            if (node.children[c-'a']!=null && searchHelper(word, k+1, node.children[c-'a'])) {
                return true;
            }
        }

        // other cases
        return false;

    }

}
