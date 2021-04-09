package Hot100;

/**
 * @author wqf
 * @date 2021/4/3 17:43
 * @Email:284660487@qq.com
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        return deep(root);
    }

    public int deep(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(deep(node.left), deep(node.right));
    }

}
