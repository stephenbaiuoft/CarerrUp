package Leetcode;

/*
*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
]

Output: ""

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
* */

/*
* 解题思路！！！
* 注意 给你的order的顺序是排好的 问题只是字母的相对应顺序没有
* 所以：
* build a graph based on indegree of each node!!!
* 因为 假设 b -> a, c -> a, d - >c 那
*    a的indegree为2
*    b为0
*    c为1
*    d为0
*
*    所以从indegree为0的开始， 然后把相邻的字母的indegree都减少1
*    最后 最后的graph里面 是否还存在indegree大一1的字符 （假设indegree 0都没有了） 那就是说明顺序逻辑有问题！！！
*
*    注意
*    1。 用hashmap来存indegree
*
* - string 1 对比string 2 找到第一个不同
*
* */

import java.util.*;

public class L269_H {
    public L269_H() {
        String[] words = new String[] {
                "wrt","wrf","er","ett","rftt"
        };


        String rez = alienOrder(words);

        String rez1 = alienOrderSol(words);
    }

    public String alienOrder(String[] words) {
        //check base cases
        if (words == null || words.length < 1) return "";

        // each character with set of characters that it precedes!!!!
        HashMap<Character, Set<Character>> map = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        // Now, let's build the map!
        // but step 0 is to do
        // we need to initialize indegree first based on the characters in the words set
        for (String word: words) {
            for(char c: word.toCharArray()) {
                indegree.put(c, 0);
            }
        }

        // now step 1 is to construct map based on comparing s1, s2 of their first different character
        for(int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            int l = Math.min(s1.length(), s2.length());

            for (int j = 0; j < l; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                // update the indegree now
                if (c1 != c2) {
                    // 只有c1 在c2之前 加一次就可以了 avoid duplicates 然后逻辑会出错
                    Set<Character> set = null;
                    if (map.containsKey(c1)) set = map.get(c1);
                    else set = new HashSet<>();

                    //只有set 第一次的时候
                    if (!set.contains(c2)) {
                        set.add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);

                        // update map
                        map.put(c1, set);
                    }

                    break;
                }
            }
        }

        // now indegree queue
        Queue<Character> q = new LinkedList<>();
        for(char c: indegree.keySet()) {
            if(indegree.get(c) == 0) {
                q.add(c);
            }
        }

        while(!q.isEmpty()) {
            char c = q.remove();
            // update the sb value
            sb.append(c);

            //重要
            // 因为degree 是0的character是不会存在map里的 值没有存
            if (map.containsKey(c)) {
                for(char c2: map.get(c)) {
                    indegree.put(c2, indegree.get(c2) - 1);
                    if (indegree.get(c2) == 0) {
                        q.add(c2);
                    }
                }
            }

        }

        if (sb.length() == indegree.size()) return sb.toString();
        return "";
    }

    public String alienOrderSol(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
}
