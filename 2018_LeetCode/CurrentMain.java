import July.L763_PartitionLabels_M;
import July.L819_MostCommonWord_E;
import June.*;
import May.*;
import rubrikMayJune.BoxStacking_M;
import rubrikMayJune.StringTest;

import java.util.*;

public class CurrentMain {
    public static void main(String[] args) {
        L763_PartitionLabels_M p = new L763_PartitionLabels_M();

//        L819_MostCommonWord_E p = new L819_MostCommonWord_E();
//        TestSpace p = new TestSpace();

//        GoogleSample p  = new GoogleSample();
//        L683_KEmptySlots_H p = new L683_KEmptySlots_H();
//        L681_NextClosestTime_M p = new L681_NextClosestTime_M();


//        L647_PalindromeSubstring_M p = new L647_PalindromeSubstring_M();

//        BoxStacking_M p = new BoxStacking_M();
//        L500_FindWords_E p = new L500_FindWords_E();

//        L227_CalculatorIII_M p = new L227_CalculatorIII_M();

//        L300_LongestSubsequence_M p = new L300_LongestSubsequence_M();

//        L53_MaxSubArray_M p = new L53_MaxSubArray_M();

//        L448_FindDuplicatesArray_E p = new L448_FindDuplicatesArray_E();

//        L164_MaxGap_H p = new L164_MaxGap_H();

//        L433_MinGeneticMut_M p = new L433_MinGeneticMut_M();
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

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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
