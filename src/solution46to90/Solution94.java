package solution46to90;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: wqf
 * Date: 2020/3/12
 * Time: 17:36
 */
public class Solution94 {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //非递归实现树的中序遍历（栈）
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) return result;
    Stack<TreeNode> stack = new Stack<>();

    while (true){
      stack.push(root);
      if(root.left != null){
        root = root.left;
      }else{
        while (!stack.empty() && stack.peek().right == null){
          result.add(stack.pop().val);
        }
        if(!stack.empty()){
          TreeNode node = stack.pop();
          result.add(node.val);
          root = node.right;
        }else{
          break;
        }
      }

    }
    return result;
  }
}
