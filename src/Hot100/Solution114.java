package Hot100;

import java.util.Stack;

/**
 * @author wqf
 * @date 2021/4/5 0:14
 * @Email:284660487@qq.com
 */
public class Solution114 {

    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode node = root;
        TreeNode lastNode = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || node != null){
            if(node != null){
                if(node.right != null){
                    stack.push(node.right);
                }
                if(lastNode != null) {
                    lastNode.right = node;
                    lastNode.left = null;
                }
                lastNode = node;
                node = node.left;
            }else{
                node = stack.pop();
            }
        }
        System.out.println("aaa");
    }

    //!!!后序遍历
    TreeNode pre = null;
    public void flatten1(TreeNode root) {
        if(root == null) return;
        flatten1(root.right);
        flatten1(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public static void main(String[] args){
        Solution114 solution114 = new Solution114();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        solution114.flatten1(node1);
    }

}
