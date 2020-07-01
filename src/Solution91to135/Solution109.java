package Solution91to135;

import java.util.ArrayList;
import java.util.List;

public class Solution109 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

   //待续
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        return construct(list, 0, list.size() - 1);
    }

    public TreeNode construct(List<Integer> list, int left, int right){
        if(left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = construct(list, left, mid - 1);
        node.right = construct(list, mid + 1, right);
        return node;
    }
}
