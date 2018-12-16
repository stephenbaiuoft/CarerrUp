package OARelated;

public class GoogleOA {

//    x     x
//    x s   x
//    x x   x
//    x x x s x
//1 2 3 1 4
//    Input 1: terrain map [2,3,1,4]
//    Input 2: indices of sprinkler locations [2,3 ]
//
//    s
//    x       x
//    x s   s x
//    x x s x x
//    x x x x x x
//1 2 3 1 4 5
//
//    input1 = [1,1,1,1,1,1,1]
//    input2 = [0,1,2,3,4,5,6]
//
//            -> O(KN) with K sprinkler and N number of terrain sequences
//
//    Expected output: [true, true, true, false]

    // return array of indice of the state of each sequence
    public boolean[] getWaterResult(int[] input1, int[] input2) {
        // sanity check here
        if (input1 == null || input2 == null) return null;

        boolean[] results = new boolean[input1.length];
        for (int index: input2) {
// do the expand the mapping logic
            expand(results, input1, index);
        }

        return results;
    }

    private void expand(boolean[] results, int[] input1, int sIndex) {
        results[sIndex] = true;
        int left = sIndex - 1;
        int right = sIndex + 1;
        while (left > -1 && input1[left] <= input1[sIndex]) {
            results[left] = true;
            left--;
        }
        while (right < input1.length && input1[right] <= input1[sIndex]) {
            results[right] = true;
            right++;
        }
    }

}
