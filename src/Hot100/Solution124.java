package Hot100;

/**
 * @author wqf
 * @date 2021/4/5 10:50
 * @Email:284660487@qq.com
 */
public class Solution124 {

    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        lrd(root);
        return max;
    }

    public int lrd(TreeNode node){
        if(node == null) return 0;
        int left = lrd(node.left);
        int right = lrd(node.right);
        int cur = node.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
        if(cur > max){
            max = cur;
        }
        int up = node.val + Math.max(left, right);
        return  up > 0 ? up : 0;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node7;
        node4.right = node8;
        node3.left = node5;
        node3.right = node6;
        node6.right = node9;
        Solution124 solution124 = new Solution124();
        solution124.maxPathSum(node1);
        System.out.println(solution124.max);
    }

}
