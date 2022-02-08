package linkedlist;

public class Test {
    class Node {
        Node next;
        int value;
    }

    public boolean isCycle(Node head) {
        if (head == null) return false;
        // 2 pointers to verify if there exists a cycle
        Node fast = head;
        Node slow = head;


        while (fast != null && fast.next != null) {
           // Advance first, or we'd have both fast/slow point to head initially
           slow = slow.next;
           fast = fast.next.next;

           if (fast == slow) return true;
        }

        // fast has reached null, no cycle
        return false;
    }
}
