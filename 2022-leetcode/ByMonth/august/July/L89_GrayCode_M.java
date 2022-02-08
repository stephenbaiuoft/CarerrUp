package ByMonth.august.July;

import java.util.ArrayList;
import java.util.List;

public class L89_GrayCode_M {
    public List<Integer> grayCode(int n) {
        List<Integer> l = new ArrayList<>();
        l.add(0);
        if (n < 1) return l;

        l.add(1);
        for(int i = 2; i <=n ; i++) {
            // baseOffset
            int baseOffset = 1 << (i-1);
            for(int j = baseOffset - 1; j > -1; j--) {
                l.add(l.get(j)+ baseOffset);
            }
        }

        return l;
    }
}
