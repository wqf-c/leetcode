package CodeTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wqf
 * @date 2021/5/30 17:46
 * @Email:284660487@qq.com
 */
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty() || node != null){
            if(node != null){
                rst.add(node.val);
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop().right;
            }
        }
        return rst;
    }

}
