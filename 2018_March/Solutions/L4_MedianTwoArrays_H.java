package Solutions;

// --> find the median using log(min(m,n))
//     wehre m and n are the length of the two arrays correspondingly
public class L4_MedianTwoArrays_H {
    public L4_MedianTwoArrays_H() {
        int[] nums1 = new int[] {1};
        int[] nums2 = new int[] {1};
        findMedianSortedArrays_Sol(nums1, nums2);

    }

    public double findMedianSortedArrays_Sol(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays_Sol(nums2, nums1);
        }

        int l = 0;
        int r = nums1.length;

        // find the median
        int l1 = nums1.length;
        int l2 = nums2.length;
        // (1 + 1 +1) / 2 ==> 1
        // (1 + 2 +1) / 2 ==> 2


        //定义k 是因为这样的话
        // 如果l1+l2是odd， 那么 kth element正好是 median （k-1th) 的右边
        // 注意：    l1+l2 == even 不影响  而且还是需要算 k-1th这个数字
        int k = (l1 + l2 +1 )/2;

        // Binary Search
        while(l < r) {
            int m1 = l + (r - l)/2;
            int m2 = k - m1;
            // m1-1, m1
            // m2-1, m2
            // m2-1 < m1
            if (nums1[m1] < nums2[m2-1]){
                l = m1 + 1;
            } else {
                r = m1;
            }
        }

        int m1 = l;
        int m2 = k - l;

        // max of the 2
        int c1 = Math.max( m1 <=0 ? Integer.MIN_VALUE: nums1[m1-1],
                m2 <=0 ? Integer.MIN_VALUE: nums2[m2-1]
        );

        if ((l1+l2) % 2 == 1){
            return c1;
        }

        int c2 = Math.min( m1 >= l1? Integer.MAX_VALUE: nums1[m1],
                m2 >= l2? Integer.MAX_VALUE: nums2[m2]
        );

        return (c1+c2)/2.0;

    }
}

