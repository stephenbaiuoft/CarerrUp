package April;

public class L689_Max3Sub_H {
    public L689_Max3Sub_H() {
        int[] input = new int[] {
                7,13,20,19,19,2,10,1,1,19
        };
        int[] rez = maxSumOfThreeSubarrays(input, 3);
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // step 1 create array s.t each index corresponds to sum of k consecutive values

        // so create sum of values in the reverse order: tail to head sum
        for(int i = nums.length - 2; i > -1; i--) {
            nums[i] += nums[i+1];
        }
        // nums[i] = difference between sum(tail to i_th) - sum(tail to i+k_th)
        for(int i = 0; i < nums.length - k; i++) {
            nums[i] = nums[i] - nums[i+k];
        }

        int maxVal = 0;
        int[] rez = new int[3];
        for(int first = 0; first < nums.length - 3*k; first ++) {
            int fVal = nums[first];
            for(int second= first + k; second < nums.length - 2 *k; second++) {
                int sVal = fVal + nums[second];
                for(int third = second + k; third < nums.length - k + 1; third++) {
                    int tVal  = sVal + nums[third];
                    if(tVal > maxVal) {
                        maxVal = tVal;
                        rez[0] = first;
                        rez[1] = second;
                        rez[2] = third;
                    }
                }
            }
        }

        return rez;
    }
}
