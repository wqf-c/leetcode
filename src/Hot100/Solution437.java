package Hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wqf
 * @date 2021/4/22 22:04
 * @Email:284660487@qq.com
 */
public class Solution437 {

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return preOrder(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int preOrder(TreeNode node, int target){
        if(node == null) return 0;
        int cur = 0;
        if(target - node.val == 0){
            cur = 1;
        }
        return cur + preOrder(node.left, target - node.val) + preOrder(node.right, target - node.val);
    }

    public int pathSum1(TreeNode root, int targetSum) {
        if(root == null) return 0;
        // key是前缀和, value是大小为key的前缀和出现的次数
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return recursionPathSum(root, 0, targetSum, prefixSumCount);
    }

    public int recursionPathSum(TreeNode node, int curNum, int target, Map<Integer, Integer> prefixSumCount){
        if(node == null){
            return 0;
        }
        curNum += node.val;
        int cur = prefixSumCount.getOrDefault(curNum - target, 0);
        prefixSumCount.put(curNum, prefixSumCount.getOrDefault(curNum, 0) + 1);
        cur += recursionPathSum(node.left, curNum, target, prefixSumCount);
        cur += recursionPathSum(node.right, curNum, target, prefixSumCount);
        prefixSumCount.put(curNum, prefixSumCount.get(curNum) - 1);
        return cur;
    }

    public static void main(String[] args) {
        Solution437 solution437 = new Solution437();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        System.out.println(solution437.pathSum(node1, 3));

    }

}
