import algorithm.related.design.L528_RandomPickWithWeight_M;
import algorithm.related.structure.L315_CountSmaller_H;
import common.data.types.TreeNode;


import java.util.*;

public class CurrentMain {

    public static void main(String[] args) {
        L528_RandomPickWithWeight_M p = new L528_RandomPickWithWeight_M();
//        L315_CountSmaller_H p = new L315_CountSmaller_H();
//        FenwickTreeDemo d = new FenwickTreeDemo();
//        L139_WordBreak_M p = new L139_WordBreak_M();


        // L849_MaxDistanceSitting_E p = new L849_MaxDistanceSitting_E();

        // L165_CompareVersionNumber_M p = new L165_CompareVersionNumber_M();
        // L402_RemoveKDigits_M p = new L402_RemoveKDigits_M();

        //CutTheSticks c = new CutTheSticks();
        //LongestIncreasingSequence l = new LongestIncreasingSequence();

        // SteppingNumber n = new SteppingNumber();

        // ColorfulNumber p = new ColorfulNumber();

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//    CurrentMain p = new CurrentMain();
//        p.foo();
    private void foo() {
        System.out.println("do nothing");
    }


    private static void hashTest() {
        HashSet<common.data.types.TreeNode> set = new HashSet<>();
        TreeNode r = new common.data.types.TreeNode(1);
        common.data.types.TreeNode first = r;
        set.add(first);

        common.data.types.TreeNode second =r;
        // point third to first
        common.data.types.TreeNode third = first;

        if (set.contains(first)) {
            System.out.print("Check: the first pointer is in set");
        }
        if (set.contains(second)) {
            System.out.print("second pointer's pointed value is there");
        }
        // check whether first is equivalent to second
        if(first == second) {
            System.out.print("pointer equivalnet?");
        }

        if (first.hashCode() == second.hashCode()) {
            System.out.print("hash code equivalent");
        }
    }
}