package Solution91to135;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       // if(root == null) return null;
        List<List<Integer>> lists = new LinkedList<>();
        preOrder(root, lists, 0);
      //  Collections.reverse(lists);
        return lists;
    }

    void preOrder(TreeNode root, List<List<Integer>> lists, int floor){
        if(root == null) return;
        if(lists.size() <= floor){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(0, list);
        }else{
            lists.get(lists.size()-floor-1).add(root.val);
        }
        preOrder(root.left, lists, floor + 1);
        preOrder(root.right, lists, floor + 1);
    }
}
