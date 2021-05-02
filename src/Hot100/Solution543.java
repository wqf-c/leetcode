package Hot100;

/**
 * @author wqf
 * @date 2021/4/26 23:31
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
        if(left + right + 1 > max){
            max = left + right + 1;
        }
        return 1 + Math.max(left, right);
    }
}
