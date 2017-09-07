package Amazon;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 //Test Function
 L2_AddTwoNums_M program = new L2_AddTwoNums_M();
 program.test();

 *
 *
 */

public class L2_AddTwoNums_M {

    public void test(){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);

        ListNode head = addTwoNumbers(l1, l2);
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = addTwoNode(l1, l2, false);
        return head;
    }

    // returns the result of the two nodes
    private ListNode addTwoNode(ListNode l1, ListNode l2, Boolean addOne){
          // base condition of returning
          if(l1 == null && l2 == null && addOne == false) return null;

          int val1;
          int val2;
          ListNode l1n;
          ListNode l2n;
          if(l1 == null ){
              val1 = 0;
              l1n = null;
          } else {
              val1 = l1.val;
              l1n = l1.next;
          }
          if (l2 == null){
              val2 =0;
              l2n = null;
          } else{
              val2 = l2.val;
              l2n = l2.next;
          }


          int sum = val1 + val2;
          Boolean nextAddOne = false;

          if(addOne){
              sum += 1;
          }

          if (sum >= 10){
              sum -= 10;
              nextAddOne = true;
          }

          ListNode result = new ListNode(sum);
          result.next = addTwoNode(l1n, l2n, nextAddOne);
          return result;

    }
}
