package Solution91to135;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution113 {

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        function(root, sum, 0);
        return result;
    }

    public void function(TreeNode node, int sum, int current){
        if(node == null) return;
        temp.add(node.val);
        if(node.left == null && node.right == null){
            if(current + node.val == sum){
                List<Integer> list = new ArrayList<>();
                list.addAll(temp);
                result.add(list);
            }
            return;
        }
        if(node.left != null){
            function(node.left, sum, current + node.val);
            temp.remove(temp.size() - 1);
        }

        if(node.right != null){
            function(node.right, sum, current + node.val);
            temp.remove(temp.size() - 1);
        }

    }


}
