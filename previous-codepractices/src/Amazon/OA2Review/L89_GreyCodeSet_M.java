package Amazon.OA2Review;

import java.util.ArrayList;
import java.util.List;

// remember is key is:     00 01| 11, 10
public class L89_GreyCodeSet_M {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if(n == 0) return result;

        // handle the n = 1 case
        result.add(1);

        for (int i = 2; i <= n; i ++) {
            int add = 1 << (i - 1);
            // ending index
            for(int j =  add - 1; j > -1; j -- ) {
                int component = result.get(j) + add;
                result.add(component);
            }

        }
        return result;
    }
}
