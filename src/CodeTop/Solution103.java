package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wqf
 * @date 2021/5/9 23:06
 * @Email:284660487@qq.com
 */
public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if(root == null) return rst;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int left = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if(left == -1){
                    list.add(0, node.val);
                }else{
                    list.add(node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            rst.add(list);
            left *= -1;
        }
        return rst;
    }

}
