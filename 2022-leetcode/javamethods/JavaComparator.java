package javamethods;

import java.util.Comparator;

public class JavaComparator {
    public void cDemo() {
        // Always define in the latter!
        Comparator c = new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        };

    }
}
