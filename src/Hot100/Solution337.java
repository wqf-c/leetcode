package Hot100;

/**
 * @author wqf
 * @date 2021/4/21 22:42
 * @Email:284660487@qq.com
 */
public class Solution337 {

    TreeNode dp;

    public int rob(TreeNode root) {
        dp = new TreeNode(0);
        dfs(root, dp);
        return dp.val;
    }

    public void dfs(TreeNode node, TreeNode dpNode){
        if(node == null){
            dpNode.val = 0;
            return;
        }
        TreeNode dpLeft = new TreeNode(0);
        TreeNode dpRight = new TreeNode(0);
        dfs(node.left, dpLeft);
        dfs(node.right, dpRight);
        dpNode.left = dpLeft;
        dpNode.right = dpRight;
        int lleft = dpLeft.left == null ? 0 : dpLeft.left.val;
        int lRight = dpLeft.right == null ? 0 : dpLeft.right.val;
        int rLeft = dpRight.left == null ? 0 : dpRight.left.val;
        int rRight = dpRight.right == null ? 0 : dpRight.right.val;
        dpNode.val = Math.max(dpLeft.val + dpRight.val, node.val + lleft + lRight + rLeft + rRight);
    }

}
