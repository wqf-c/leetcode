package CodeTop;

/**
 * @author wqf
 * @date 2021/5/11 0:14
 * @Email:284660487@qq.com
 */
public class Solution236 {

    TreeNode rst = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return rst;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if(rst != null) return true;
        int find = 0;
        if(node == p || node == q){
            find = 1;
        }
        if(node.left != null && dfs(node.left, p, q)){
            find++;
        }
        if(rst != null) return true;
        if(find < 2 && node.right != null && dfs(node.right, p, q)){
            find ++;
        }
        if(find == 2){
            rst = node;
        }
        return find > 0;
    }

}
