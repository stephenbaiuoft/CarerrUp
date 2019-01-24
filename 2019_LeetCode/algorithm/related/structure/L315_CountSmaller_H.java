package algorithm.related.structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class L315_CountSmaller_H {
    public L315_CountSmaller_H() {
        int[] nums = new int[] {
                5, 2, 6, 1
        };

        List<Integer> l = countSmaller(nums);

    }

    public List<Integer> countSmaller(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        // the array to store result
        List<Integer> list = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(copy); // ascending order ==> n(logn)
        int rank = 1;
        for(int i = 0; i < copy.length; i++) {
            // map value to rank
            // so first smallest would be 1 and etc
            if (!map.containsKey(copy[i])) {
                // update rank and also map value to rank
                map.put(copy[i], rank++);
            }
        }

        // the freqTable that stores # of elements
        int[] freqTable = new int[map.size()+1];

        // create a FenwickTree
        FenwickTree fTree =new FenwickTree(map.size());

        // now iterate through num, from back to start
        int curRank = -1;
        for (int i = nums.length - 1; i > -1; i--) {
            // get the current value's rank
            curRank = map.get(nums[i]);
            // update the freqTable
            freqTable[curRank]++;

            // remember the offset so -1 to query results up to curRank (excluding curRank)
            list.add(fTree.query(curRank-1));
            // update the fTree with delta equal to 1, as it's one entity
            fTree.update(curRank, 1);
        }

        return list;

    }

    class FenwickTree {
        int[] sum = null;
        int n = -1;
        public FenwickTree(int n) {
            sum = new int[n+1];
            this.n = n;
        }

        public void update(int i, int delta) {
            while(i<=n) {
                sum[i] += delta;
                i += getLowBit(i);
            }
        }

        public int query(int i) {
            int tot = 0;
            while (i > 0) {
                tot += sum[i];
                i -= getLowBit(i);
            }
            return tot;
        }

        private int getLowBit(int x) {
            // lowest 1 value
            return x & (-x);
        }
    }
}
