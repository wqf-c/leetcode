package Hot100;

/**
 * @author wqf
 * @date 2021/4/14 0:37
 * @Email:284660487@qq.com
 */
public class Solution236 {

    int findNum = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        boolean flag = false;
        if(root == q || root == p){
            findNum ++;
            flag = true;
        }
        if(findNum == 2) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(findNum == 2){
            if(!flag) return left;
            else return root;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(findNum == 2){
            if(!flag && left == null) return right;
            else return root;
        }
        if(left != null || right != null || flag) return root;
        return null;
    }
}
