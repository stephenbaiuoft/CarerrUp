package treemap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;

public class L1094_CarPooling_M {
    public static void main(String[] args) {
        L1094_CarPooling_M p = new L1094_CarPooling_M();
        // [[4,5,6],[6,4,7],[4,3,5],[2,3,5]]
        int[][] trips = new int[4][3];
        trips[0] = new int[]{4,5,6};
        trips[1] = new int[]{6,4,7};
        trips[2] = new int[]{4,3,5};
        trips[3] = new int[]{2,3,5};
        p.carPooling(trips, 13);
    }

    //
    public boolean carPooling(int[][] trips, int capacity) {
        // pos_i on +, off -N
        // sort by[pos_i, value]
        // iterate through pos_i starting from minium and keep capacity
        int[][] inputs = new int[trips.length * 2][2];
        int j = 0;
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            int[] onboard = new int[]{
                    trip[1], trip[0]
            };

            int[] offboard = new int[] {
                    trip[2], -trip[0]
            };

            inputs[j++] = onboard;
            inputs[j++] = offboard;
        }

        // sort based on the ith position, and we'd always go with offboard first
        // and default is ascending, so always offboard first
//        BiFunction<int[], int[], Integer> lambda = (a, b) -> {
//            if (a[0] == b[0]) {
//                return a[1] - b[1];
//            } else {
//                return a[0] - b[0];
//            }
//        };

        Arrays.sort(inputs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int cur = 0;
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("cur and input is: " + cur + " | "  + inputs[i][0] + " " + inputs[i][1] );

            cur += inputs[i][1];
            if (cur > capacity) {
                return false;
            }
        }

        return true;
    }
}
