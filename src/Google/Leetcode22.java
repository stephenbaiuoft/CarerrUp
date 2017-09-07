package Google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by stephen on 7/18/17.
 */
public class Leetcode22 {
    private List<String> storage;
    public Leetcode22(){
        this.storage = new LinkedList<>();
    }

    public List<String> generateParenthesis(int n) {
        if(n==0) return this.storage;

        bracketTrace("",0, 0, n );
        return this.storage;
    }

    private void bracketTrace( String traceLine,int leftCount, int rightCount, int n){
        if(leftCount < n){
            bracketTrace(traceLine + "(", leftCount+1, rightCount, n);
        }
        if(rightCount < leftCount){
            bracketTrace(traceLine+")", leftCount , rightCount+1, n);
        }
//        else if( rightCount > leftCount){
//            System.out.println("never executed?");
//            return;
//        }
        // left and right both equal to number, n
        else if(leftCount == rightCount && leftCount ==n){
            storage.add(traceLine);
        }

    }

}
