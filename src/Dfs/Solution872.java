package Dfs;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wqf
 * @date 2020/11/28 23:27
 * @Email:284660487@qq.com
 */
public class Solution872 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        stack.push(root1);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null) list.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        stack.clear();
        int index = 0;
        stack.push(root2);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null) {
                if(index >= list.size()) return false;
                if(list.get(index) != node.val) return false;
                index++;
            }
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        if(index != list.size()) return false;
        return true;
    }

}
