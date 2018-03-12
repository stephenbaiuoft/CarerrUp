package Leetcode;

public class L208_Trie_M {
    class TrieNode {
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root = null;
    /** Initialize your data structure here. */
//    public Trie() {
//        // initialize root
//        this.root = new TrieNode();
//    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i ++) {
            char cc = word.charAt(i);
            int index = cc - 'a';
            if (curNode.children[index] == null) {
                // init new TrieNode
                TrieNode child = new TrieNode();
                curNode.children[index] = child;
                curNode = child;
            }
            // update curNode
            else {
                curNode = curNode.children[index];
            }
        }
        // update the last curNode
        curNode.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) return false;
        TrieNode curNode = root;
        for (int i = 0; i< word.length(); i++) {
            char cc = word.charAt(i);
            int index = cc - 'a';
            if (curNode.children[index] == null) {
                return false;
            } else {
                curNode = curNode.children[index];
            }
        }

        return curNode.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        TrieNode curNode = root;
        for (int i = 0; i< prefix.length(); i++) {
            char cc = prefix.charAt(i);
            int index = cc - 'a';
            if (curNode.children[index] == null) {
                return false;
            } else {
                curNode = curNode.children[index];
            }
        }
        return true;

    }
}
