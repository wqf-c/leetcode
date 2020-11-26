package tree;

import java.util.Stack;

/**
 * @author wqf
 * @date 2020/11/14 22:40
 * @Email:284660487@qq.com
 */
public class Solution222 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int height = 0;
    int leafCount = 0;
    boolean first = true;
    boolean finish = false;
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int totalCount = 0;
        preOrder(root, 1);
        totalCount = (int) Math.pow(2, height - 1) - 1 + leafCount;
        return totalCount;
    }

    public void preOrder(TreeNode node, int depth){
        if(finish) return;
        if(node.left == null && node.right == null){
            if(first){
                first = false;
                height = depth;
                leafCount++;
            }else{
                if(depth == height) {
                    leafCount++;
                }else{
                    finish = true;
                }
            }
            return;
        }
        if(node.left == null || node.right == null && !first){
            finish = true;
            leafCount += node.left == null ? 0 : 1;
            leafCount += node.right == null ? 0 : 1;
            return;
        }
        if(node.left != null){
            preOrder(node.left, depth + 1);
        }
        if(node.right != null){
            preOrder(node.right, depth + 1);
        }else{
            finish = true;
        }
    }

}
