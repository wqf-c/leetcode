package Bfs;

import java.util.*;

/**
 * @author wqf
 * @date 2020/12/3 20:16
 * @Email:284660487@qq.com
 */
public class Solution863 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int x) {
            val = x;
        }
    }



    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list;
        list = new ArrayList<>();
        if(K == 0){
            list.add(target.val);
            return list;
        }
        findTarget(root, target.val);
        int cur = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if(node.parent != null){
                    queue.offer(node.parent);
                }
                if(node.left != null && node.left.parent == null){
                    queue.offer(node.left);
                }
                if(node.right != null && node.right.parent == null){
                    queue.offer(node.right);
                }
            }
            if(cur == K) break;
            cur++;
        }
        while (!queue.isEmpty()){
            list.add(queue.poll().val);
        }
        return list;
    }

    public boolean findTarget(TreeNode node, int target){
        if(node.val == target) {
            return true;
        }
        boolean leftFlag = false;
        boolean rightFLag = false;
        if(node.left != null){
            leftFlag = findTarget(node.left, target);
        }
        if(leftFlag) {
            node.left.parent = node;
            return true;
        }
        if(node.right != null){
            node.right.parent = node;
            return true;
        }

        return false;
    }

}
