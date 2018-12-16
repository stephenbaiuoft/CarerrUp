package OARelated;
import java.io.*;
import java.util.*;

public class BlinkHealth {

/*
Write code to parse urls into a sitemap tree structure and display it as text. For example, the following urls will result in this printed structure.

Milestones:
1. Parse routes into data structure
2. Print data structure as simply as possible to check parsing
3. Format text output like shown in below

/home/anti-depressants/xanax
/home/heart/lipitor
/home/heart/atorvastatin
/home/heart/lipitor
/home/heart/heart
/drugs/nasal/flonase
/drugs/topical
/drugs/routes/oral/tablets
/drugs/routes/nasal/flonase

- home
- anti-depressants
    - xanax
- heart
    - lipitor
    - atorvastatin
    - heart
- drugs
- nasal
    - flonase
- topical
- routes
    - oral
        - tablets
    - nasal
        - flonase
*/

    // a base node structure storing node set


    class  Node {
        HashMap<String, Node> children = null;
        String nodeVal = null;
        public Node(String s1) {
            nodeVal = s1;
            children = new HashMap<>();
        }

        // insert value into children
        public Node insert(String s1) {
            Node create = new Node(s1);
            // put in the key-value pair
            children.put(s1, create);
            return create;
        }

        // get the node that contains string s1, null if s1 does not exist
        public Node getNode(String s1) {
            // return the value associated with the key
            return children.get(s1);
        }
    }

    private Node root = new Node("");

    // insert s1 given the root node
    public void insertValue(String str) {
        String[] strComponents = str.split("\\/");
        System.out.println("root value is: <" + root.nodeVal+ ">");
        Node cur = root;

        for (int i = 1; i < strComponents.length; i++ ) {
            String component = strComponents[i];

            // no component
            if (cur.getNode(component) == null) {
                System.out.println("new connection: " + cur.nodeVal + "->" + component);
                cur = cur.insert(component);
            } else {// component does exist in the cur node
                System.out.println("moving up: " + cur.nodeVal + "->" + component);
                cur = cur.getNode(component);
            }


        }
        System.out.println("end of insertion");
    }

    public void runTest() {
        String[] inputs = {
                "/home/anti-depressants/xanax",
                "/home/heart/lipitor",
                "/home/heart/atorvastatin"
        };


        for (String input: inputs) {
            insertValue(input);
        }
    }
}
