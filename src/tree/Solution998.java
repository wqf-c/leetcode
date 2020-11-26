package tree;

/**
 * @author wqf
 * @date 2020/11/8 21:10
 * @Email:284660487@qq.com
 */
public class Solution998 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(val > root.val) {
            node.left = root;
            return node;
        }
        TreeNode pre = root;
        TreeNode next = pre.right;
        while (next != null && next.val > val){
            next = next.right;
            pre = pre.right;
        }
        pre.right = node;
        node.left = next;
        return root;
    }
}
