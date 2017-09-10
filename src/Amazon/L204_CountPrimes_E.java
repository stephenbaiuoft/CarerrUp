package Amazon;
/**
 * Description:

 Count the number of prime numbers less than a non-negative number, n.

 */

public class L204_CountPrimes_E {
    public int countPrimes(int n) {
        int[] track = new int[n];
        int count = 0;

        for(int i = 2; i < n; i ++){
            if(track[i]==0){
                count ++;
                mark(i, track, n);
            }
        }

        return count;
    }

    private void mark(int startIndex, int[] record, int n ){
        int i = 2;
        while(startIndex * i < n){
            record[startIndex * i ] = -1;
            i++;
        }
    }
}
