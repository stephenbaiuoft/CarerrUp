package custom_data_structure;

import java.util.ArrayList;
import java.util.HashMap;

public class L900_RLEIterator_M {
    private int[] A = null;
    private int cIdx = 0; // keep track of the count
    private int q = 0; // quantity exhausted so far for cIdx

    public L900_RLEIterator_M(int[] A) {
        this.A = A;
    }

    public int next(int n) {
        while (cIdx < A.length) {
            if (q + n > A[cIdx]) {
                // find out how much more exhausted required
                n -= (A[cIdx] - q); // A[cIdx] - q remaining quantities to be exhasted
                // set q to 0, and the next loop will update q regardless
                q = 0;
                cIdx += 2;
            }
            else {
                // update q
                q += n;
                return A[cIdx+1];
            }
        }

        // default
        return -1;
    }
}


