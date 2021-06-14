package CodeTop;

/**
 * @author wqf
 * @date 2021/6/4 23:15
 * @Email:284660487@qq.com
 */
public class Solution124 {

    int max;

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        max = root.val;
        pathSum(root);
        return max;
    }

    public int pathSum(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = pathSum(node.left);
        int right = pathSum(node.right);
        int rst = Math.max(node.val, Math.max(node.val + left, node.val + right));
        int temp = node.val;
        temp += left > 0 ? left : 0;
        temp += right > 0 ? right : 0;
        max = Math.max(temp, max);
        return rst;
    }

    public static void main(String[] args) {
        Solution124 solution124 = new Solution124();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(-2);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(-2);
        TreeNode node7 = new TreeNode(-1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;
        System.out.println(solution124.maxPathSum(node1));
    }
}
