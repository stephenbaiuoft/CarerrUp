package dynamicprogramming;

public class L849_MaxDistanceSitting_E {
    public L849_MaxDistanceSitting_E() {
        maxDistToClosest(new int[] {
                1, 0, 0, 0
        });
    }

    public int maxDistToClosest(int[] seats) {
        // previous Sitting index
        int pS = -1;
        // current Sitting index
        int cS = -1;
        int maxD = 1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                cS = i;
                if (pS > -1) {
                    // find the distance in between
                    // find the mid point, round the smallest, and get distance
                    int mid = pS + (cS-pS)/2;
                    maxD = Math.max(maxD, mid -pS);
                }
                // update previous Sitting state
                pS = cS;
            }
        }
        // only 1 sitting only, and all other are 0
        if (pS == -1)  {
            maxD = Math.max(cS - 0, seats.length - cS);
        }

        return maxD;
    }
}
