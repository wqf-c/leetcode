package Dfs;

/**
 * @author wqf
 * @date 2020/12/3 19:01
 * @Email:284660487@qq.com
 */
public class Solution513 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int rst = -1;
    int maxDepth = -1;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return rst;
    }

    public void dfs(TreeNode node, int depth){
        if(node.left == null && node.right == null){
            if(depth > maxDepth){
                maxDepth = depth;
                rst = node.val;
            }
        }
        if(node.left != null){
            dfs(node.left, depth + 1);
        }
        if(node.right != null){
            dfs(node.right, depth + 1);
        }
    }

}
