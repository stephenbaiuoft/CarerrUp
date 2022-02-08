package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note: All inputs will be in lower-case.
 *
 */

// idea: convert str to char[26] representation (given int and char can be converted freely)
// => back to str ==> to be hashed
public class L49_GroupAnagram_M {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<List<String>> result = new ArrayList<List<String>>();

        for(String str: strs) {
            char[] ary = str.toCharArray();
            Arrays.sort(ary);

            String hashStr = new String(ary);
            String output = String.format("hashStr is: %s", hashStr);
            System.out.println(output);

            if (hashMap.containsKey(hashStr)) {
                hashMap.get(hashStr).add(str);

            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(hashStr, list);
            }
        }

        result.addAll(hashMap.values());

        return result;
    }

}
