package July;

import java.util.ArrayList;
import java.util.List;

public class L119_PascalTriangleII_E {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) return list;

        // base case
        list.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            int l = list.size();
            list.add(1);
            // reverse order
            for(int j = l - 1; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j-1));
            }
        }

        return list;
    }
}
