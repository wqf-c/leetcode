package Bfs;

import java.util.*;

/**
 * @author wqf
 * @date 2020/12/7 0:34
 * @Email:284660487@qq.com
 */
public class Solutionoffer_32 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if(root == null) return rst;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean right = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = null;
            if(right){
                list = new LinkedList<>();
            }else{
                list = new ArrayList<>();
            }
            for(int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if(right) list.add(0, node.val);
                else list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            right = !right;
            rst.add(list);
        }
        return rst;
    }

}
