package March;

import java.util.HashMap;

public class L220_ContainDuplicatesIII_M {
    public L220_ContainDuplicatesIII_M() {
        int[] t = new int[] {
          0, 2147483647
        };
        containsNearbyAlmostDuplicate(t, 1, 2147483647);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || t < 0) return false;
        HashMap<Long, Long> map = new HashMap<>();

        long bucketId = 0;
        long curVal = 0;
        // this takes care of the corner case where t = 0
        long bucketSize = (long) t + 1;
        for(int i = 0; i < nums.length; i ++) {
            bucketId = nums[i]/bucketSize;
            curVal = nums[i];
            // you still need Math.abs(curlVal - map.get(bucketId)) because -N and +N maps to the same bucketID!!!
            if(map.containsKey(bucketId) && Math.abs(curVal - map.get(bucketId)) < bucketSize) {
                return true;
            } else if (map.containsKey(bucketId - 1) && ( curVal - map.get(bucketId -1) ) < bucketSize ) {
                return true;
            } else if (map.containsKey(bucketId + 1) && (map.get(bucketId+1) - curVal ) < bucketSize) {
                return true;
            }

            map.put(bucketId, curVal);
            if(i >= k) {
                // remove the i-t's value
                map.remove(nums[i-k]/bucketSize);
            }

        }
        return false;
    }
}
