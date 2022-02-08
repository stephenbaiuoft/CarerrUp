package feb22prep.thirty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L18_4Sum_M {
    public static void main(String[] args) {
        System.out.println("running??");
        L18_4Sum_M p = new L18_4Sum_M();
    }



    public L18_4Sum_M() {
        int[] nums = {1,0,-1,0,-2,2};

        int[] nums1 = {2,2,2,2,2};
        fourSum(nums1, 8).forEach(
                l -> {
                    System.out.print("[");
                    l.forEach(
                        v -> System.out.print(v + ",")
                    );
                    System.out.println("]");
                }
        );
    }

    // let's write a modular expression or idea
    public List<List<Integer>> fourSumQuicker(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        if (nums == null || nums.length < 4) return list;

        Arrays.sort(nums);

        // here let's apply the 4 sum logic on top of the 3 sum logic
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            threeSumHelper(nums, list, i+1, nums[i], target);
        }

        return list;
    }

    // given start index, find the 3sum, with val that equals to target
    private void threeSumHelper(int[] nums, List<List<Integer>> list, int start, int val, int target) {

        for (int i = start; i < nums.length - 2; i++) {
            // remove duplicates
            if (i > start && nums[i-1] == nums[i]) {
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            int sum = 0;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right] + val;
                if (sum == target) {
                    List l1 = new LinkedList();
                    l1.add(val);
                    l1.add(nums[i]);
                    l1.add(nums[left]);
                    l1.add(nums[right]);
                    list.add(l1);

                    // update left and right indice
                    left++;
                    right--;
                    // remove duplicates for left and right pointer
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while(right > left && nums[right] == nums[right+1]) {
                        right--;
                    }
                }
                else if (sum < target ) {
                    left ++;
                } else { // sum > target
                    right--;
                }

            }

        }
    }




    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            List<List<Integer>> threeR = threeSum(nums, i + 1, target - nums[i]);
            int a = nums[i]; // byPass the lambda
            if (threeR.size() != 0) {
                // add to result
                for (int j = 0; j < threeR.size(); j++)
                {
                    threeR.get(j).add(a);
                }

                result.addAll(threeR);
            }

        }

        return result;

    }

    // let's a build 3Sum solution
    // sIndex as the index to go through
    // for an array starting of sIndex, get # of combinations that can sum up to target
    public List<List<Integer>> threeSum(int[] nums, int sIndex, int target) {
        int left, right;
        List<List<Integer>> result = new LinkedList<>();

       for (int i = sIndex; i < nums.length - 2; i++) {
            if (i > sIndex && nums[i-1] == nums[i]) {
                continue;
            }

            int lookfor = target - nums[i];
            left = i + 1;
            right = nums.length -1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == lookfor) {
                    List<Integer> tmp = new LinkedList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    result.add(tmp);
                    // update
                    left += 1;
                    right -= 1;


                    // Remove duplicates only in found case!!!!
                    // Because if no match, next duplicate won't match anyway
                    // If will always get you the first match
                    // Now left < right and right > left is sooooo IMPORTANT!!!!
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (right > left && nums[right+1] == nums[right]) {
                        right--;
                    }
                } else if (sum < lookfor) {
                    left += 1;
                } else {
                    right -= 1;
                }

            }

        }

        return result;
    }
}
