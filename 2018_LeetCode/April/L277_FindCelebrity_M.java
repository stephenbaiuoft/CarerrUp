package April;

public class L277_FindCelebrity_M {
    // make this dummy function
    private boolean knows(int a, int b) {
        return true;
    }

    public int findCelebrity(int n) {
        // first loop:
        // if there were a celebrity, then
        // others must know that number, so candidate = i;
        // Note, the celebrity does not know anyone, so
        // candidate will stuck there
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }

        // check the case where there is no celebrity
        // so candidate is 0, who does not know anyone
        // and others ppl also are not recognized by the rest
        for(int i = 0; i < n; i++) {
            //
            if( i != candidate) {
                // case i: some i DOES NOT know the candidate --> return false (candidate should be known by all others)
                // case ii: >1 celebrities  --> the candidate knows others (not supposed to) --> return false
                if(!knows(i, candidate) || knows(candidate, i))  {
                    return -1;
                }
            }
        }

        return candidate;
    }
}
