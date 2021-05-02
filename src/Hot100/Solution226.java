package Hot100;

/**
 * @author wqf
 * @date 2021/4/14 0:18
 * @Email:284660487@qq.com
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = rightNode;
        leftNode.right = leftNode;
        return root;
    }

}
