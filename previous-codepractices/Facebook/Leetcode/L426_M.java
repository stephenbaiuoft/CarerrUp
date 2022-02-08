package Leetcode;


public class L426_M {
    public Node treeToDoublyList(Node root) {

        Node[] rez = toList(root);
        if (rez != null) {
            return rez[0];
        }
        return null;
    }

    // Node[]
    // 0th: the head of Node c's subtree (whether left or right)
    // 1st: the tail of Node c's subtree (whether left or right)

    private Node[] toList(Node c){
        if(c == null) return null;

        Node[] result = {c,c};

        Node[] l = toList(c.left);
        Node[] r = toList(c.right);

        if(l != null) {
            result[0]=l[0];
            c.left=l[1];
            l[1].right=c;
        }
        if(r != null){
            result[1]=r[1];
            c.right=r[0];
            r[0].left=c;
        }


        // this is important!!
        // link the node's head to tail and tail to head !!!!!!!!
        result[0].left = result[1];
        result[1].right = result[0];
        return result;
    }
}
