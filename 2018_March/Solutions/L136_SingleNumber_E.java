package Solutions;

public class L136_SingleNumber_E {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int rez = nums[0];
        for(int i = 1; i < nums.length; i++) {
            rez ^= nums[i];
        }

        return rez;
    }
}
