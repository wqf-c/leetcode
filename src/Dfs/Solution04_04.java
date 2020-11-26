package Dfs;

/**
 * @author wqf
 * @date 2020/11/25 22:28
 * @Email:284660487@qq.com
 */
public class Solution04_04 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        int depth = dfs(root);
        if(depth == -1) return false;
        return true;
    }

    int dfs(TreeNode node){
        if(node == null) return 0;
        int left = dfs(node.left);
        if(left == -1) return -1;
        int right = dfs(node.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
