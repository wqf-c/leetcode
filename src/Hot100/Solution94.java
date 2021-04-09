package Hot100;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wqf
 * @date 2021/3/30 22:35
 * @Email:284660487@qq.com
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if(root == null) return rst;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                rst.add(root.val);
                root = root.right;
            }
        }

        return rst;
    }

}
