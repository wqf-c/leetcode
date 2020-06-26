package Solution91to135;

public class Solution98 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isValidBST(TreeNode root) {
        return judge(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean judge(TreeNode node, long min, long max){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        return judge(node.left, min, node.val) && judge(node.right, node.val, max);
    }
}
