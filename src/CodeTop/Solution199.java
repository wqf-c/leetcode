package CodeTop;

import Hot100.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wqf
 * @date 2021/5/22 16:07
 * @Email:284660487@qq.com
 */
public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> rst = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            rst.add(((LinkedList<TreeNode>) queue).getLast().val);
            for(int i = 0; i < size; ++i){
                TreeNode node = ((LinkedList<TreeNode>) queue).pollFirst();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return rst;
    }

}
