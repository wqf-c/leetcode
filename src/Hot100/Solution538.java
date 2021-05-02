package Hot100;

/**
 * @author wqf
 * @date 2021/4/25 0:03
 * @Email:284660487@qq.com
 */
public class Solution538 {

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode node, int parentVal){
        if(node == null){
            return 0;
        }
        int rightVal = dfs(node.right, parentVal);
        node.val = rightVal + node.val + parentVal;
        int leftVal = dfs(node.left, node.val);

        return node.val + leftVal - parentVal;
    }

    private int sum = 0;
    public TreeNode convertBST1(TreeNode root) {
        dfs1(root);
        return root;
    }

    public void dfs1(TreeNode node){
        if(node == null){
            return;
        }

        dfs1(node.right);
        node.val = node.val + sum;
        sum = node.val;
        dfs1(node.left);
    }

}
