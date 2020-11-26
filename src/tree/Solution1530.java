package tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author wqf
 * @date 2020/11/12 22:01
 * @Email:284660487@qq.com
 */
public class Solution1530 {

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

    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        preOrder(root, distance);
        return count;
    }

    List<Integer> preOrder(TreeNode node, int distance){
        if(node.left == null && node.right == null){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if(node.left != null){
            left = preOrder(node.left, distance);
        }
        if(node.right != null){
            right = preOrder(node.right, distance);
        }
        for(Integer l : left){
            for (Integer r : right){
                if(l + r + 1 <= distance) count++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer l : left){
            list.add(l + 1);
        }
        for(Integer r : right){
            list.add(r + 1);
        }
        return list;
    }

}
