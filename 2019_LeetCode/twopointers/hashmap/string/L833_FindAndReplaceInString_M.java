package twopointers.hashmap.string;

import java.util.HashMap;

public class L833_FindAndReplaceInString_M {
    public L833_FindAndReplaceInString_M() {
        findReplaceString("vmokgggqzp",
                new int[] {3, 5, 1},
                new String[] {"kg", "ggq", "mo"},
                new String[] {"s", "so", "bfr"});
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S == null || S.length() == 0) return "";
        StringBuilder sb = new StringBuilder();

        int left = 0;
        int n = S.length();
        // store i, and idx, which is the relative position in the targets/sources/indexes
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int idxAtSource = 0; idxAtSource < indexes.length; idxAtSource++) {
            int idxAtS = indexes[idxAtSource];
            // find the idx that should be replaced
            if (S.substring(idxAtS, idxAtS + sources[idxAtSource].length()).equals(sources[idxAtSource])) {
                map.put(idxAtS, idxAtSource);
            }
        }

        while (left < n ) {
            if (map.containsKey(left)) {
                sb.append(targets[map.get(left)]);
                // increment left
                left += sources[map.get(left)].length();
            } else {
                sb.append(S.charAt(left));
                left++;
            }
        }

        return sb.toString();


    }
}
