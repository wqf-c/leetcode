package Dfs;

/**
 * @author wqf
 * @date 2020/11/29 1:02
 * @Email:284660487@qq.com
 */
public class Solution129 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rst = 0;


    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return rst;
    }

    public void dfs(TreeNode node, int current){
        if(node.left == null && node.right == null) {
            rst += current * 10 + node.val;
            return;
        }
        if(node.left != null){
            dfs(node.left, current * 10 + node.val);
        }
        if(node.right != null){
            dfs(node.right, current * 10 + node.val);
        }
    }

}
