package Solution91to135;

public class Solution112 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean hasPathSum(TreeNode root, int sum) {
        return judge(root, sum);
    }

    boolean judge(TreeNode node, int sum){
        if(node == null) return false;
        int left = sum - node.val;
        if(left == 0 && node.left == null && node.right == null) return true;
        if(left < 0) return false;
        return judge(node.left, left) || judge(node.right, left);
    }
}
