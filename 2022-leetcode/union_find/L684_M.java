package union_find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class L684_M {
    public L684_M() {
        int[][] input = {{1,2}, {1,3}, {2,3}};

        int[] result = findRedundantConnection(input);
        System.out.println(result[0] + "_" + result[1]);

    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFindSet unionSet = new UnionFindSet();

        for (int[] edge: edges) {
            // union
            if (unionSet.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return null;
    }


    public class UnionFindSet {
        HashMap<Integer, Integer> parents = new HashMap<>();
        HashMap<Integer, Integer> ranks = new HashMap<>();

        public int find(int x) {
            if (parents.get(x) == null)
            {
                parents.put(x, x);
                // set the ranks, as first time, so rank = 0
                ranks.put(x, 0);
                return x;
            }

            if (x != parents.get(x) ) {
                parents.put(x, find(parents.get(x)));
            }

            return parents.get(x);
        }


        // return false if both are the same parents as they cannot be unioned again
        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            // meaning duplicate edge here
            if (pa == pb) return false;

            else if (ranks.get(pa) < ranks.get(pb)) {
                // set parent of pb as pa
                // pa rank not changed
                parents.put(pb, pa);
            }
           else if (ranks.get(pa) > ranks.get(pb)) {
                    // set parent of pa as pb
                    parents.put(pa, pb);
                }
            else {
                    // same
                    parents.put(pb, pa);
                    // update the rank by 1
                    ranks.put(pa, ranks.get(pa)+1);
                }

            return true;
        }

    }
}
