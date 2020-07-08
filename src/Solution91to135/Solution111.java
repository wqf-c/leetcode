package Solution91to135;

public class Solution111 {

    public int minDepth(Solution95.TreeNode root) {
        int len = getLength(root);
        return len;
    }

    public int getLength(Solution95.TreeNode node){
        if(node == null) return 0;
        if(node.left != null && node.right != null){
            return Math.min(getLength(node.left), getLength(node.right)) + 1;
        }
        if(node.left != null) return getLength(node.left) + 1;
        if(node.right != null) return getLength(node.right) + 1;
        return 1;
    }
}
