package Hot100;

/**
 * @author wqf
 * @date 2021/4/2 1:01
 * @Email:284660487@qq.com
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {

        return judge(root, new int[1], new int[1]);
    }

    boolean judge(TreeNode node, int[] max, int[] min){
        int leftMin = 0, rightMax = 0;
        if(node.left != null){
            if(!judge(node.left, max, min)) return false;
            if(node.val <= max[0]) return false;
            leftMin = min[0];
        }else{
            leftMin = node.val;
        }
        if(node.right != null){
            if(!judge(node.right, max, min)) return false;
            if(node.val >= min[0]) return false;
            rightMax = max[0];
        }else{
            rightMax = node.val;
        }
        max[0] = rightMax;
        min[0] = leftMin;

        return true;
    }

    boolean judge1(TreeNode node, long min, long max){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        return judge1(node.left, min, node.val) && judge1(node.right, node.val, max);
    }

}
