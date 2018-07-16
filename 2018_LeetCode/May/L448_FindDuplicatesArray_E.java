package May;

import java.util.LinkedList;
import java.util.List;

public class L448_FindDuplicatesArray_E {
    /*
    * By (nums[i]-1) % n, we can calculate the original number in the array.
        For example, [4, 3, 2, 7, 8, 2, 3, 1]
        if i == 1, nums[i] = 3, nums[i]-1 = 2, we will visit the first 2,
        after visit this 2 will become 10, since n is 8
        if i == 2, nums[i] = 10, nums[i]-1 = 9, which is wrong
        Thus we need 10 % 8 = 2 to calculate the original number to get the index.
        if i ==2, (nums[i]-1) % n = 1, we can visit correctly
    * */
    public L448_FindDuplicatesArray_E() {
        int[] input = new int[] {
           4,3,2,7,8,2,3,1
        };

        List<Integer> result = findDisappearedNumbers(input);

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        if(nums == null || nums.length == 0) return list;

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            // increment each index n ( --> to denote it has been visited)
            // but note we use module %n  --> to get the corresponding value
            nums[(nums[i] - 1) % n] += n;
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] <= n){
                // 所以这里是加i+1 （index 表示是否相对应都数字)
                list.add(i+1);
            }
        }

        return list;
    }
}
