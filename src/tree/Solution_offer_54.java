package tree;

import java.util.Stack;

/**
 * @author wqf
 * @date 2020/11/10 22:51
 * @Email:284660487@qq.com
 */
public class Solution_offer_54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        int find = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()){
            if(node != null){
                stack.push(node);
                node = node.right;
            }else{
                node = stack.pop();
                find++;
                if(find == k) return node.val;
                node = node.left;
            }
        }
        return 0;
    }

}
