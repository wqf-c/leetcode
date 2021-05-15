package CodeTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wqf
 * @date 2021/5/14 23:55
 * @Email:284660487@qq.com
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()){
            if(node == null){
                node = stack.pop();
                rst.add(node.val);
                node = node.right;
            }else{
                stack.push(node);
                node = node.left;
            }
        }
        return rst;
    }

}
