package javamethods;

public class JavaPassByReference {
    public static void main(String[] args) {
        JavaPassByReference p = new JavaPassByReference();
        p.testDemo();

    }

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public void testDemo() {
        Node cur = null;
        helper(cur);

        System.out.println(cur);

    }

    private void helper(Node cur) {
        cur = new Node(2022);
    }

}
