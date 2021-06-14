package CodeTop;

/**
 * @author wqf
 * @date 2021/6/2 23:13
 * @Email:284660487@qq.com
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftH = height(node.left);
        if(leftH < 0){
            return -1;
        }
        int rightH = height(node.right);
        if(leftH < 0 || rightH < 0 || Math.abs(leftH - rightH) > 1){
            return -1;
        }
        return Math.max(leftH, rightH) + 1;
    }


}
