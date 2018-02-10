package IBM_OA;

import java.util.*;

public class TrieTree {

    class TrieNode {
        private char c;
        private String s;
        private boolean isWord;

        private HashMap<Character, TrieNode> childMap = new HashMap<>();
        public TrieNode(char c, String s) {
            this.c = c;
            this.s = s;
        }

        public TrieNode() {
        }

    }

    // insert string and store to this node
    public void insert(String input, TrieNode node) {
        HashMap childMap = node.childMap;
        for(int i = 0; i < input.length(); i++) {
            TrieNode p = null;
            // check if contained
            char c = input.charAt(i);
            if ( childMap.containsKey(c) ) {
                // re-point p now
                p = (TrieNode) childMap.get( c);
            } else{
                // create and do the link
                p = new TrieNode(c, input.substring(0, i + 1) );
                childMap.put(c, p);
            }

            // important!!1 or you may lose stuff
            if(i == input.length() - 1) {
                p.isWord = true;
            }
            // re-point childMap now
            childMap = p.childMap;
        }

    }

    // get all String stored under this node
    private void getString(TrieNode node, List<String> resultSet) {
        Iterator<TrieNode> itr = node.childMap.values().iterator();

            while(itr.hasNext()){
                TrieNode n = itr.next();
                if(n.isWord ) {
                    resultSet.add(n.s);
                }
                getString(n, resultSet);
            }


    }

    // find the node, containing the prefix ==> i'll use recursion later to get all strings
    private TrieNode searchNode(String prefix, TrieNode node) {
        HashMap childMap = node.childMap;
        TrieNode p = null;
        for(int i = 0; i < prefix.length(); i++) {

            // check if contained
            char c = prefix.charAt(i);

            // if containg c
            if(childMap.containsKey(c)) {
                p = (TrieNode) childMap.get(c);
                childMap = p.childMap;
            } else{
                // does not contain
                return null;
            }
        }
        // p is the node containing the last character by the end
        return p;

    }

    public void run() {
        TrieNode root = new TrieNode();

        insert("to", root);
        insert("tea", root);
        insert("inn", root);
        insert("ted", root);
        insert("ten", root);
        insert("inn", root);
        insert("abdk", root);
        insert("teaddf", root);
        insert("teddda", root);
        insert("tessdfd", root);

        TrieNode r = searchNode("te", root);
        List<String> resultSet = new LinkedList<>();
        getString(r, resultSet);

        Iterator<String> i = resultSet.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }


    }


}