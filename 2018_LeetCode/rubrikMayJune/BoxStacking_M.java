package rubrikMayJune;

import java.util.Arrays;
import java.util.Comparator;

public class BoxStacking_M {
        public BoxStacking_M() {
            int[][] boxes = new int[][] {
                    {3,5,4}, {2,5,6},{4,4,3}
            };
            int rez = findTallestStacks(boxes);
        }


        public int findTallestStacks(int[][] boxes) {
            Comparator<int[]> c = new Comparator<int[]>() {
                @Override
                public int compare(int[] box1, int[] box2) {
                    return box2[1] * box2[2] - box1[1] * box1[2];
                }
            };

            Arrays.sort(boxes, c);

            int[] dp = new int[boxes.length];
            int maxHeight = 0;
            for (int i = 0; i < boxes.length; i++) {
                // the base case of the default height!!!
                    dp[i] = boxes[i][0];
                for (int j = 0; j < i; j++) {
                    // 因为order是 0 index 最大的面积 --> so j going from 0 to ith
                    // so --> boxes[j][1] >= boxes[i][1] && boxes[j][2] >= boxes[i][2]
                    if (boxes[j][1] >= boxes[i][1] && boxes[j][2] >= boxes[i][2]) {
                        // 所以是 dp[j] + boxes[i][0] given this ith box, and [j] is
                        // maximum height stacked so far
                        dp[i] = Math.max(dp[i], dp[j] + boxes[i][0]);
                    }
                }
                maxHeight = Math.max(maxHeight, dp[i]);
            }

            return maxHeight;
        }


}
