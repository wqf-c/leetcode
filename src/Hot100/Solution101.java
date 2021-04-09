package Hot100;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wqf
 * @date 2021/4/2 22:35
 * @Email:284660487@qq.com
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int[] dataStore = new int[size * 2];
            for(int i = 0; i < size; ++i){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                    dataStore[i * 2] = cur.left.val;
                }else{
                    dataStore[i * 2] = Integer.MIN_VALUE;
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                    dataStore[i * 2 + 1] = cur.right.val;
                }else{
                    dataStore[i * 2 + 1] = Integer.MIN_VALUE;
                }
            }
            for(int i = 0; i < size; ++i){
                if(dataStore[i] != dataStore[size * 2 - i - 1]) return false;
            }
        }
        return true;
    }

    public boolean helper(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null) return false;
        if(node1.val == node2.val){
            return helper(node1.left, node2.right) && helper(node1.right, node2.left);
        }
        return false;
    }

}
