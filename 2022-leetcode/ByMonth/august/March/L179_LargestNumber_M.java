package ByMonth.august.March;

import java.util.Arrays;
import java.util.Comparator;

public class L179_LargestNumber_M {
    // testing.string comparison
    public L179_LargestNumber_M() {
        String s1 = "996";
        String s2 = "9";
        String s3 = "199";
        int v12 = s1.compareTo(s2);
        int v23 = s2.compareTo(s3);
        int v13 = s1.compareTo(s3);

        String sv = String.valueOf(996);

        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                // largest first, then smaller ones with s2 compareTo s1
                return s2.compareTo(s1);
            }
        };

        String[] s = new String[3];
        s[0] = s1;
        s[1] = s2;
        s[2] = s3;
        Arrays.sort(s, c);

        int[] nums = new int[] {1, 2};
        String sn = largestNumber(nums);
    }

    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        StringBuilder sb = new StringBuilder();
        // idea: lexigraphical order in decreasing order, where largest first

        // Memorize the comparator syntax
        Comparator<String> c = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;

                // this order makes sure the largest combination is placed first
                return s2.compareTo(s1);
            }
        };

        String[] s = new String[nums.length];
        for(int i = 0; i < s.length; i++) {
            // String.valueOf(num[i])
            s[i] = String.valueOf(nums[i]);
        }

        // sort the array
        Arrays.sort(s, c);
        // corner case where all 0s
        if (s[0].charAt(0) == '0') {
            return "0";
        }

        for(String element: s) {
            sb.append(element);
        }

        return sb.toString();
    }
}
