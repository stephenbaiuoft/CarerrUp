package algorithm.related.sharding;

import java.util.*;

public class L520_ConsistentHashing_M {
    // https://www.lintcode.com/problem/520/description
    public class Solution {
        private int n, k;
        private TreeMap<Integer, Integer> tree;  // shard -> machineId

        public  Solution create(int n, int k) {
            Solution sol = new Solution();
            sol.n = n;
            sol.k = k;
            sol.tree = new TreeMap<>();

            return sol;
        }

        public List<Integer> addMachine(int machine_id) {
            List<Integer> list = new ArrayList<>();
            Random rand = new Random();

            for (int i = 0; i < k; ) {
                int shard = rand.nextInt(n);
                if (! tree.containsKey(shard)) {
                    list.add(shard);
                    tree.put(shard, machine_id);
                    i++;
                }
            }

            return list;
        }

        public int getMachineIdByHashCode(int hashcode) {
            if (tree.isEmpty())
                throw new IllegalStateException("No machine added yet.");

            Map.Entry<Integer, Integer> entry = tree.ceilingEntry(hashcode);
            return entry == null ? tree.firstEntry().getValue() : entry.getValue();
        }
    }
}
