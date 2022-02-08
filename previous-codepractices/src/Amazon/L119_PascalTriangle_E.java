package Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?


            ************Test************
 L119_PascalTriangle_E program = new L119_PascalTriangle_E();
 program.getRow(3);
 */

public class L119_PascalTriangle_E {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int curRow = 0;
        while(curRow <= rowIndex) {
            result.add(1);
            // let's do reverse order
            for(int j = curRow - 1; j > 0; j--){
                int tmp = result.get(j - 1) + result.get(j);
                result.set(j, tmp);
            }
            curRow ++;
        }

        return result;
    }
}
