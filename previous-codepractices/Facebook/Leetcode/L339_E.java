package Leetcode;

import java.util.List;

public class L339_E {
    // dummy class
    class NestedInteger {
        public boolean isInteger() {
            return true;
        }

        public Integer getInteger() {
            return null;
        }

        public List<NestedInteger> getList() {
            return null;
        }
    }

    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger i : nestedList) {
            sum += computeSum(i, 1);
        }

        return sum;
    }


    private int computeSum(NestedInteger item, int level) {
        int sum = 0;
        if (item.isInteger()) {
            return level * item.getInteger();
        } else {
            List<NestedInteger> l = item.getList();
            for( NestedInteger i : l) {
                sum += computeSum(i, level + 1);
            }
            return sum;
        }
    }

}
