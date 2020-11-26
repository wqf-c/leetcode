package Dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2020/11/20 22:12
 * @Email:284660487@qq.com
 */
public class Solution971 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int voyageIndex = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> rst = new ArrayList<>();
        boolean flag = preOrder(root, voyage, rst);
        if(!flag){
            rst.clear();
            rst.add(-1);
        }
        return rst;
    }

    public boolean preOrder(TreeNode node, int[] voyage, List<Integer> list){
        if(voyageIndex >= voyage.length || node.val != voyage[voyageIndex]) return false;
        voyageIndex++;
        if((node.left != null || node.right != null) && voyageIndex >= voyage.length) return false;
        if(node.left != null && node.left.val != voyage[voyageIndex]){
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            list.add(node.val);
        }

        if(node.left != null){
            boolean leftFlag = preOrder(node.left, voyage, list);
            if(!leftFlag) return false;
        }
        if(node.right != null){
            boolean right = preOrder(node.right, voyage, list);
            if(!right) return false;
        }
        return true;
    }


    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        Solution971 solution971 = new Solution971();
        System.out.println(solution971.flipMatchVoyage(node1, new int[]{1, 3, 2}));
    }
}
