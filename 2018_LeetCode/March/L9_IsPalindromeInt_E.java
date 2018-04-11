package March;

public class L9_IsPalindromeInt_E {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x!= 0 && x%10 == 0)) return false;

        int rev = 0;
        // only does half way comparison!! important!!!!!!!
        while(x > rev ) {
            rev = rev*10 + x %10;
            x/= 10;
        }

        // the or --> in case when x/=10 and then x is smaller then rev
        // so we need to consider this case as well
        return rev == x || rev/10 == x;

    }
}
