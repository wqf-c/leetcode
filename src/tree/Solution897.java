package tree;

import java.util.Stack;

/**
 * @author wqf
 * @date 2020/11/10 21:56
 * @Email:284660487@qq.com
 */
public class Solution897 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode rst = null;
        TreeNode before = null;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                if(rst == null) rst = node;
                if(before == null) before = node;
                else {
                    before.right = node;
                    before.left = null;
                    before = before.right;
                }
                node = node.right;
            }
        }
        return rst;
    }

}
