package CodeTop;

/**
 * @author wqf
 * @date 2021/6/3 0:06
 * @Email:284660487@qq.com
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
