package ByMonth.august.May;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class L229_MajorityElement_M {
    public L229_MajorityElement_M() {
        int nums[] = new int[]{
          3,2,3
        };

        List<Integer> rez = majorityElement(nums);
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rez = new ArrayList<>();
        // m1, c1, m2, c2 to keep track
        int m1, m2, c1, c2 ;
        m1 = m2 = c1 = c2  = 0;

        for(int num: nums) {
            if (m1 == num) {
                c1++;
            }
            else if (m2 == num) {
                c2++;
            }
            else if (c1 == 0) {
                m1 = num;
                c1 =1;
            }
            else if (c2 == 0) {
                m2 = num;
                c2 = 1;
            }
            else {
                // this element is new, so subtract both c1, c2
                // 因为 相当于这个新的element 要把之前的都少一个
                // 这样 > 1/3都element 反正肯定最后还会出来的
                c1--;
                c2--;
            }
        }

        // double check whether c1, c2 fits (logic --> )
        c1 = 0;
        c2 = 0;
        for(int num: nums) {
            if (num == m1) {
                c1++;
            }
            else if (num == m2) {
                c2++;
            }
        }

        if(c1 > nums.length/3){
            rez.add(m1);
        }
        if(c2 > nums.length/3) {
            rez.add(m2);
        }

        return rez;
    }
}
