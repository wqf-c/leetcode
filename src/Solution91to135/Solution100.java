package Solution91to135;

import java.util.Stack;

public class Solution100 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null) ^ (q == null)) return false;
        if(p == null && q == null) return true;
        Stack<TreeNode> tree1 = new Stack<>();
        Stack<TreeNode> tree2 = new Stack<>();
        tree1.push(p);
        tree2.push(q);
        while (!tree1.empty()){
            TreeNode node1 = tree1.pop();
            TreeNode node2 = tree2.pop();
            if(node1.val != node2.val) return false;
            if((node1.left == null) ^ (node2.left == null)) return false;
            if((node1.right == null) ^ (node2.right == null)) return false;
            if(node1.left != null){
                tree1.push(node1.left);
                tree2.push(node2.left);
            }
            if(node1.right != null){
                tree1.push(node1.right);
                tree2.push(node2.right);
            }
        }
        return true;
    }
}
