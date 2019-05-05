package Amazon;
import java.sql.Struct;
import java.util.*;


// understad the importance of pre-order and sortalgo
// because apparently u always!! needs to root node
public class L297_SerializeDeserialize_H {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public void test(){
//        common.data.types.TreeNode testHead  = new common.data.types.TreeNode(0);
//        testHead.left = new common.data.types.TreeNode(1);
//        testHead.right = new common.data.types.TreeNode(3);
//
//        testHead.left.left = new common.data.types.TreeNode(2);
//        testHead.right.left = new common.data.types.TreeNode(4);
//
//        testHead.right.left.right = new common.data.types.TreeNode(5);

        TreeNode t = new TreeNode(1);

        String serializedOutput = serialize(t);
        System.out.println("serialized testing.string: " + serializedOutput);



        TreeNode testHeadDeserialized = deserialize(serializedOutput);


    }

    static private String nullNode = "N";
    static private String Splitter = ",";
    private StringBuilder serializedString;
    private TreeNode treeHead = null;
    private LinkedList<String> treeQueue = null;

    public String serialize(TreeNode root) {
        serializedString = new StringBuilder();
        buildSerializedString(root);
        return serializedString.toString();
    }

    // pre-order
    public void buildSerializedString(TreeNode node){
        if(node == null){
            serializedString.append(nullNode).append(Splitter);
        }else{
            serializedString.append(node.val).append(Splitter);
            buildSerializedString(node.left);
            buildSerializedString(node.right);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeArray = data.split(Splitter);
        treeQueue = new LinkedList(Arrays.asList(nodeArray));

        treeHead = buildDeserializedTree();
        return treeHead;
    }

    // build a tree by assigning the treeHead
    private TreeNode buildDeserializedTree(){
        if(!treeQueue.isEmpty()){
            String removal = treeQueue.removeFirst();
            if(!nullNode.equals(removal)){
                TreeNode node = new TreeNode(Integer.parseInt(removal));
                node.left = buildDeserializedTree();
                node.right = buildDeserializedTree();
                return node;
            }else{
                return null;
            }

        }
        // should not occur here
        System.out.println("correct queue means should not reach here");
        return null;
    }

}