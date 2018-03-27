import Solutions.*;

import java.util.*;

public class MarchMain {
    public static void main(String[] args) {
        L8_StringToInteger_M p = new L8_StringToInteger_M();
//        L561_ArrayPartition_E p = new L561_ArrayPartition_E();

//        L6_ZigZag_M p = new L6_ZigZag_M();
//        L7_ReverseInteger_E p = new L7_ReverseInteger_E();

//        L415_AddString_E p = new L415_AddString_E();
//        hashTest();

//        L95_UniqueBST_M p = new L95_UniqueBST_M();

//        L4_MedianTwoArrays_H p = new L4_MedianTwoArrays_H();

//        L294_FlipGameII_M p = new L294_FlipGameII_M();

//        L2_AddTwoNums_M p = new L2_AddTwoNums_M();
//        L149_MaxPointsLine_H p = new L149_MaxPointsLine_H();

    }



    private static void hashTest() {
        HashSet<TreeNode> set = new HashSet<>();
        TreeNode r = new TreeNode(1);
        TreeNode first = r;
        set.add(first);

        TreeNode second =r;
        // point third to first
        TreeNode third = first;

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
