package StringRelated;

public class L442_Trie {

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    private TrieNode head = null;
    public L442_Trie() {
        // do intialization if necessary
        this.head = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        if (word == null || word.length() < 1) return;

        TrieNode curNode = head;
        int charIndex= 0;
        for (int i = 0; i < word.length();i++) {
            charIndex = word.charAt(i) - 'a';
            if (curNode.children[charIndex] == null) { // construct new TrieNode
                curNode.children[charIndex] = new TrieNode();
            }
            curNode = curNode.children[charIndex]; // advance curNode
        }

        curNode.isWord = true;// last one
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode rez = dfs(word, 0, this.head);

        if (rez == null) return false;
        return rez.isWord;
    }

    private TrieNode dfs(String word, int curIndex, TrieNode node) {
        // write your code here
        if (word == null || word.length()<1) return node;

        TrieNode cur = node;
        for (int i = curIndex; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                return null; // does not exist
            }
            else {
                cur = cur.children[word.charAt(i) - 'a'];
            }
        }

        return cur;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode rez = dfs(prefix, 0, this.head);
        if (rez == null) return false;
        return true;
    }

}
