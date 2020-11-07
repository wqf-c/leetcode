package tree;


import java.util.*;

/**
 * @author wqf
 * @date 2020/11/7 20:43
 * @Email:284660487@qq.com
 */
public class Solution_offer_32_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> rst = new ArrayList<>();
        preOrder(root, 1, rst);
        return rst;

    }

    public void preOrder(TreeNode node, int depth, List<List<Integer>> lists){
        if(node == null) return;
        if(depth > lists.size()){
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            lists.add(list);
        }else{
            lists.get(depth - 1).add(node.val);
        }
        preOrder(node.left, depth + 1, lists);
        preOrder(node.right, depth + 1, lists);
    }

    //非递归,广度优先
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> rst = new ArrayList<>();
        if(root == null) return rst;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            rst.add(list);
        }
        return rst;

    }

}
