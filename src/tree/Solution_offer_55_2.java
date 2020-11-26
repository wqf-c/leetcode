package tree;

/**
 * @author wqf
 * @date 2020/11/18 23:38
 * @Email:284660487@qq.com
 */
public class Solution_offer_55_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(preOrder(root) == -1) return false;
        return true;
    }

    public int preOrder(TreeNode node){
        if(node == null) return 0;
        int left = preOrder(node.left);
        if(left == -1) return -1;
        int right = preOrder(node.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

}
