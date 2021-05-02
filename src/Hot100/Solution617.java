package Hot100;

/**
 * @author wqf
 * @date 2021/4/29 0:13
 * @Email:284660487@qq.com
 */
public class Solution617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    public TreeNode dfs(TreeNode node1, TreeNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        TreeNode node1Left = node1 == null ? null : node1.left;
        TreeNode node1Right = node1 == null ? null : node1.right;
        TreeNode node2Left = node2 == null ? null : node2.left;
        TreeNode node2Right = node2 == null ? null : node2.right;
        node1.val = node1.val + node2.val;
        node1.left = dfs(node1Left, node2Left);
        node1.right = dfs(node1Right, node2Right);
        return node1;
    }



}
