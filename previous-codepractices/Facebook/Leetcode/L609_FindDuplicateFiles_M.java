package Leetcode;

import java.util.*;

public class L609_FindDuplicateFiles_M {
    public L609_FindDuplicateFiles_M() {
        String[] t = new String[]{
                "root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        findDuplicate(t);
    }

    public List<List<String>> findDuplicate(String[] paths) {
        // base case
        if (paths == null || paths.length == 0) {
            return null;
        }

        // variables
        Map<String, List<String>> map = new HashMap<>();
        for(String path: paths) {
            String[] components = path.split(" ");
            String root = components[0];
            // process each file
            for (int i = 1; i < components.length; i++) {
                // get "(" index
                int index = components[i].indexOf("(");
                String content = components[i].substring(index);
                String file = components[i].substring(0, index);

                if (map.containsKey(content)) {
                    map.get(content).add(root + "/" + file);
                } else{
                    List<String> l = new LinkedList<>();
                    l.add(root + "/" + file);
                    map.put(content, l);
                }
            }
        }
        List<List<String>> rez = new ArrayList<>();
        for (List<String>l: map.values()) {
            if (l.size() > 1) {
                rez.add(l);
            }
        }

        return rez;
    }
}
