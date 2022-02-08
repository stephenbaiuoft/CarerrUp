package Leetcode;

public class LH_IndexII {
    public LH_IndexII() {
        int[] input = new int[]{
                0, 1, 3, 5, 6
        };

        int h = hIndex(input);
        System.out.println(h);
    }


    public int hIndex(int[] citations) {
        if (citations == null || citations.length < 1) return 0;

        int left = 0;
        int n = citations.length;
        int right = n - 1;
        int val = 0, mid = 0;

        while(left  < right){
            mid = left + (right-left)/2;
            val = citations[mid];
            if (n - mid - 1 > val) {
                left = mid + 1;
            }
            // n - mid - 1 <= val
            else {
                right = mid;
            }
        }
        // edge condition

        // key first is the fact that left >= citations[left] if left does move !!!!
        // however, it is possible left < citations[left] with cases such as [0], then
        // we should return the citation[left] value

        return citations[left] < n - left ? citations[left]: n - left;
    }
}
