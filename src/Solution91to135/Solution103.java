package Solution91to135;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution103 {


    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        add(root, lists, 0);
        return lists;
    }

    public void add(TreeNode node, List<List<Integer>> lists, int floor){
        if(node == null) return;
        if(floor >= lists.size()){
            List<Integer> list = null;
            if(floor % 2 == 0) list = new ArrayList<>();
            else list = new LinkedList<>();
            list.add(node.val);
            lists.add(list);
        }else{
            if(floor % 2 == 0){
                lists.get(floor).add(node.val);
            }else{
                lists.get(floor).add(0, node.val);
            }

        }
        add(node.left, lists, floor + 1);
        add(node.right, lists, floor + 1);
    }
}
