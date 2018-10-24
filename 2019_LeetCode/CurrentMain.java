import OARelated.CutTheSticks;
import bfs.or.dfs.ColorfulNumber;
import bfs.or.dfs.NumberTriangle;
import bfs.or.dfs.SteppingNumber;
import common.data.types.TreeNode;
import dynamic_programming.LongestIncreasingSequence;
import stack_zgl.L402_RemoveKDigits_M;


import java.awt.*;
import java.util.*;

public class CurrentMain {
    public static void main(String[] args) {
        L402_RemoveKDigits_M p = new L402_RemoveKDigits_M();

        //CutTheSticks c = new CutTheSticks();
        //LongestIncreasingSequence l = new LongestIncreasingSequence();

        // SteppingNumber n = new SteppingNumber();

        // ColorfulNumber p = new ColorfulNumber();

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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
