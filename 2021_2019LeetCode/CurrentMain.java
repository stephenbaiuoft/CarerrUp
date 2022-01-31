import common.data.types.TreeNode;
import dynamicprogramming.L1067_DigitCountInRangeNonWorking_H;
import dynamicprogramming.L1067_DigitCountInRange_H;


import java.util.*;

public class CurrentMain {
    // testClass to try out java cases

    public static void main(String[] args) {
        L1067_DigitCountInRange_H p = new L1067_DigitCountInRange_H();
//        Lint563_Backpack4 lt563 = new Lint563_Backpack4();
//        Lint92_Backpack Lt92=  new Lint92_Backpack();
//        L324WiggleSort w = new L324WiggleSort();
//        L312BurstBalloons l312 = new L312BurstBalloons();
//        quickSort q = new quickSort();
//        L5LongestPalindromicSubstring L5 = new L5LongestPalindromicSubstring();
//        L740_deleteAndEarn L740 = new L740_deleteAndEarn();
//        L127_WordLadder_M l127 = new L127_WordLadder_M();
//        L684_M l684 = new L684_M();
//         L25_ReverseNodesInKGroup_H p =new L25_ReverseNodesInKGroup_H();
//        L394_DecodeString_M p = new L394_DecodeString_M();
//        L973_KClosestPoints_M p = new L973_KClosestPoints_M();
//        NumArray p = new NumArray();
//        L316_RemoveDuplicateLetters r = new L316_RemoveDuplicateLetters();

//        CustomSortString_M s = new CustomSortString_M();
//        L940_DistinctSubsequencesII_H h = new L940_DistinctSubsequencesII_H();
//        L524_LongestWordInDicThroughDeleting_M m = new L524_LongestWordInDicThroughDeleting_M();

//        L475_Heaters_E h = new L475_Heaters_E();
//        L562_LongestLineOfConsecutiveOneInMatrix_M p = new L562_LongestLineOfConsecutiveOneInMatrix_M();
//        L900_RLEIterator_M m = new L900_RLEIterator_M();

//        L809_ExpressiveWords_M e = new L809_ExpressiveWords_M();
//        L135_Candy_H c = new L135_Candy_H();
//        binary_search_test t = new binary_search_test();
//        L833_FindAndReplaceInString_M f = new L833_FindAndReplaceInString_M();
//        L222_CountCompleteTreeNodes_M m = new L222_CountCompleteTreeNodes_M();
//        L857_MinCostKWorkers_H h = new L857_MinCostKWorkers_H();
//        L947_MostStonesRemovedWithSameRowOrCol_M v = new L947_MostStonesRemovedWithSameRowOrCol_M();
//        L18_4Sum_M s = new L18_4Sum_M();

//        L528_RandomPickWithWeight_M p = new L528_RandomPickWithWeight_M();
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
