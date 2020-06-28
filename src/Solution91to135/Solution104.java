package Solution91to135;

public class Solution104 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        return inorder(root, 1);
    }

    public int inorder(TreeNode node, int curDepth){
        if(node == null) return curDepth - 1;
        return Math.max(inorder(node.left, curDepth + 1), inorder(node.right, curDepth + 1));
    }
}
