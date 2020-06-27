package Solution91to135;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution101 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> tree1 = new Stack<>();
        Stack<TreeNode> tree2 = new Stack<>();
        TreeNode root1 = root;
        TreeNode root2 = root;
        while (!tree1.empty() || root1 != null){
            while (root1 != null){
                if(root2 == null) return false;
                tree1.push(root1);
                root1 = root1.left;
                tree2.push(root2);
                root2 = root2.right;
            }
            if(root2 != null) return false;
            TreeNode node1 = tree1.pop();
            root1 = node1.right;
            TreeNode node2 = tree2.pop();
            root2 = node2.left;
            if(node1.val != node2.val) return false;
        }

        return true;
    }

    //0ms范例

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val == node2.val) {
            return helper(node1.left, node2.right) && helper(node1.right, node2.left);
        }
        return false;
    }
}
