package Amazon;

import java.util.*;

/**
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 Return an empty list if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.

 */
/**
 * Idea: Use BFS for neighbours and constructing the tree with shortestPath to each node
 *       Use DFS to iterate through and check if
 */


/**             Test!!!
 *
 "hit"
 "cog"
 ["hot","dot","dog","lot","log","cog"]
 */


public class L126_WordLadderII_H {
    public void test(){
        String startWord = "hit";
        String endWord = "cog";
        List<String> dic = new LinkedList<>();
        dic.add("hot");
        dic.add("dot");
        dic.add("dog");
        dic.add("lot");
        dic.add("log");
        dic.add("cog");

        List<List<String>> results = findLadders(startWord, endWord, dic);
        for(List<String> result: results){
            System.out.println(result.toString());
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // create distance for each node
        HashMap<String, Integer> distance = new HashMap<>();
        // keep each string's nearby neighbours
        HashMap<String, List<String>> neighbourMap = new HashMap<>();
        HashSet<String> dict = new HashSet<>(wordList);

        // initialize empty arrayList
        List <List<String>> results = new LinkedList<>();
        //results.add(new ArrayList<>());

        boolean isFound = bfs(beginWord, endWord, dict, neighbourMap, distance);
        if (isFound) {
            LinkedList<String> result = new LinkedList<>();
            dfs(beginWord, endWord, neighbourMap, distance, result, results);
        }
        //
        return results;

    }

    private boolean bfs(String beginWord, String endWord, HashSet<String> dict, HashMap<String,
            List<String>> neighbourMap, HashMap<String, Integer> distance) {

        boolean isFound = false;
        Queue <String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);


        while( !queue.isEmpty() ) {
            String curWord = queue.poll();
            int curDistance = distance.get(curWord);
            int nextDistance = curDistance + 1;

            List<String> neighbours = findNeighbours(curWord, dict);
            // all these nodes as neighbours?
            neighbourMap.put(curWord, neighbours);

            for (String neighbour: neighbours) {
                if (!distance.containsKey(neighbour)){
                    // avoid duplicate nodes
                    queue.add(neighbour);
                    distance.put(neighbour, nextDistance);
                }
                // check if endWord can be found
                if(neighbour.equals(endWord)) {
                    // given we are looking for the Shortest Path!!! so
                    // by definition the algorithm definitely hits here
                    // break only breaks out for-loop which is Only One Word!
                    isFound = true;
                }
            }

        }

        return isFound;
    }

    // returns all nearby neighbours to a word
    private List<String> findNeighbours( String word, HashSet<String> dict) {

        ArrayList<String> results = new ArrayList<>();

        for(int i = 0; i < word.length(); i++) {
            char[] ary = word.toCharArray();
            char oriChar = ary[i];
            for(char ch = 'a'; ch <= 'z'; ch ++) {
                // skip self
                if(oriChar == ch){continue;}
                ary[i] = ch;
                String newWord = new String(ary);
                if(dict.contains(newWord)){
                    results.add(newWord);
                }
            }
        }

        return results;
    }

    // the key is result and understanding recursion!!
    private void dfs(String beginWord, String endWord, HashMap<String,
            List<String>> neighbourMap, HashMap<String, Integer> distance, LinkedList<String> result, List<List<String>> results ) {

        // add it to the result
        result.add(beginWord);
        // if found
        if(beginWord.equals(endWord)) {
            // adding a new ArrayList!!!
            results.add( new ArrayList<>(result));
        } else {
            int curDistance = distance.get(beginWord);
            for( String neighbor: neighbourMap.get(beginWord)) {
                // finding the minimum one For Sure
                if( curDistance + 1 == distance.get(neighbor) ) {
                    dfs(neighbor, endWord, neighbourMap, distance, result, results );
                }
            }
        }
        // removes the last element because it is not what we want
        result.removeLast();

    }

}
