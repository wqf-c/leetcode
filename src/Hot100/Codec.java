package Hot100;

/**
 * @author wqf
 * @date 2021/4/18 12:05
 * @Email:284660487@qq.com
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder("");
        preOrder(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void preOrder(TreeNode node, StringBuilder stringBuilder){
        if(node == null){
            stringBuilder.append("#!");
            return;
        }
        stringBuilder.append(node.val + "!");
        preOrder(node.left, stringBuilder);
        preOrder(node.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("!");
        return deserialize(strs);
    }
    int index = 0;
    public TreeNode deserialize(String[] strs){
        if(strs[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[index]));
        index++;
        node.left = deserialize(strs);
        node.right = deserialize(strs);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        Codec ser = new Codec();
        Codec deser = new Codec();
        String serialize = ser.serialize(node1);
        TreeNode ans = deser.deserialize(serialize);
    }

}
