package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2021/6/5 12:00
 * @Email:284660487@qq.com
 */
public class Solution113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        if(root == null){
            return rst;
        }
        path(root, cur, rst, targetSum);
        return rst;
    }

    public void path(TreeNode node, List<Integer> cur, List<List<Integer>> rst, int target){
        if(node == null){
            return;
        }
        cur.add(node.val);
        if(node.left == null && node.right == null && target - node.val == 0){
            List<Integer> list = new ArrayList<>();
            list.addAll(cur);
            rst.add(list);
            cur.remove(cur.size() - 1);
            return;
        }
        path(node.left, cur, rst, target - node.val);
        path(node.right, cur, rst, target - node.val);
        cur.remove(cur.size() - 1);
    }

}
