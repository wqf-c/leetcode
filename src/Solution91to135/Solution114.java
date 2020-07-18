package Solution91to135;

import java.util.Stack;

public class Solution114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack1.empty()){
            while (cur != null){
                stack1.push(cur);
                stack2.push(cur);
                cur = cur.left;
            }
            cur = stack1.pop().right;
        }
        TreeNode last = null;
        while (!stack2.empty()){
            TreeNode node = stack2.pop();
            node.right = last;
            node.left = null;
            last = node;
        }
    }

    public void flatten1(TreeNode root) {
      while (root != null){
          if(root.left == null){
              root = root.right;
          }else{
              TreeNode node = root.left;
              while (node.right != null){
                  node = node.right;
              }
              node.right = root.right;
              root.right = node;
              root.left = null;
              root = root.right;

          }
      }
    }

    TreeNode pre = null;
    public void flatten2(TreeNode root) {
        if(root == null) return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
