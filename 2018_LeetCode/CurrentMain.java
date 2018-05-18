import April.L57_InsertInterval_H;
import April.L680_ValidPalindrome_E;
import April.L689_Max3Sub_H;
import April.L721_AccountMerge_M;
import March.*;
import May.L229_MajorityElement_M;
import May.L286_WallsGates_M;
import May.L433_MinGeneticMut_M;
import May.L785_BiPartite_M;

import java.util.*;

public class CurrentMain {
    public static void main(String[] args) {
        L433_MinGeneticMut_M p = new L433_MinGeneticMut_M();
//        L229_MajorityElement_M p = new L229_MajorityElement_M();

//        L785_BiPartite_M p = new L785_BiPartite_M();
//        L721_AccountMerge_M p = new L721_AccountMerge_M();

//        L57_InsertInterval_H p = new L57_InsertInterval_H();

//        L680_ValidPalindrome_E p = new L680_ValidPalindrome_E();

//        L689_Max3Sub_H p = new L689_Max3Sub_H();
//        L179_LargestNumber_M p = new L179_LargestNumber_M();

//        L8_StringToInteger_M p = new L8_StringToInteger_M();
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
