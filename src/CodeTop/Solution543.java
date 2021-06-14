package CodeTop;

/**
 * @author wqf
 * @date 2021/6/12 23:22
 * @Email:284660487@qq.com
 */
public class Solution543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max - 1;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int cur = left + right + 1;
        if(cur > max){
            max = cur;
        }
        return Math.max(left, right) + 1;
    }

}
