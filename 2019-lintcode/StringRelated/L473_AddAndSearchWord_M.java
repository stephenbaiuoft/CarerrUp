package StringRelated;

public class L473_AddAndSearchWord_M {
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    // dummy head
    private TrieNode head = new TrieNode();

    public void addWord(String word) {
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
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        return dfs(word, 0, head);

    }

    private boolean dfs(String word, int curIndex, TrieNode node) {
        // write your code here
        if (word == null || word.length() < 1) return true;

        TrieNode cur = node;
        for (int i = curIndex; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    // any one of the condition is true, then return true
                    if (cur.children[j] != null && dfs(word, curIndex+1, cur.children[j])) {
                        return true;
                    }
                }
                return false; // this is important!! as you loop through all possibilities and all false --> false
            }
            else { // not . so --> some character case
                   if (cur.children[word.charAt(i) - 'a'] == null) {
                       return false; // does not exist
                   }
                   return dfs(word, curIndex+1, cur.children[word.charAt(i) - 'a']);
            }
        }

        return node.isWord;
    }

}
