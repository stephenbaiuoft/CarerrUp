package ByMonth.august.april;

public class L689_Max3Sub_H {
    public L689_Max3Sub_H() {
        int[] input = new int[] {
                7,13,20,19,19,2,10,1,1,19
        };
        int[] rez = maxSumOfThreeSubarrays(input, 3);
    }


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // sum accumulative sum results
        // sum[k] - sum[0] (sum[0] = 0 by default ==> k values)
        int sum[] = new int[nums.length+1];
        // left (DP array storing the max index from the left)
        int left[] = new int[nums.length];
        // right (DP array storing te max index from the right)
        int right[] = new int[nums.length];


        // init sum array
        for(int i =0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }

        // init left array DP method
        // node i ranges from [k,nums.length) !!!! so important
        for(int i = k,  tot = sum[k]  - sum[0]; i < nums.length; i++) {
            if(sum[i+1] - sum[i+1-k] > tot) {
                // update the index i+1 -k (leave out i = 0 case to be 0)
                left[i] = i+1-k;
                tot = sum[i+1] - sum[i+1-k];
            }
            else {
                left[i] = left[i-1];
            }
        }

        // init the right array DP method (note last index for righht is nums.length -1 inclusive)
        right[nums.length - k] = nums.length - k;
        // k+1 elements between n, and n  - k ===> delta = n-(n-k)  + 1 = k+1
        for(int i = nums.length - k -1, tot = sum[nums.length] - sum[nums.length-k];
            i >  -1; i--)
        {
            //  k units from  i to i+k, so --> sum starting from i, wihch makes sense
            if(sum[i + k]-sum[i] >= tot) {
                right[i] = i;
                tot = sum[i+k] - sum[i];
            }
            else {
                right[i] =  right[i+1];
            }
        }

        int maxVal = 0;
        int rez[] = new int[3];
        // test all the possible mid points
        for(int  i = k; i <= nums.length - 2*k; i++)  {
            // get left and right indice
            int l = left[i-1];
            int r = right[i+k];
            // get the corresponding values
            int mid = sum[i+k] - sum[i];
            int lval = sum[l+k]- sum[l];
            int rval = sum[r+k] - sum[r];
            int tot =  mid + lval + rval;
            if (tot > maxVal)  {
                maxVal = tot;
                rez[0]  = l;
                rez[1] = i;
                rez[2] = r;
            }
        }

        return rez;


    }
}
