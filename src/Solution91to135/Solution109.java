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

    private ListNode head;

    private int findSize(ListNode head) {
        ListNode ptr = head;
        int c = 0;
        while (ptr != null) {
            ptr = ptr.next;
            c += 1;
        }
        return c;
    }

    private TreeNode convertListToBST(int l, int r) {
        // Invalid case
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;

        // First step of simulated inorder traversal. Recursively form
        // the left half
        TreeNode left = this.convertListToBST(l, mid - 1);

        // Once left half is traversed, process the current node
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;

        // Maintain the invariance mentioned in the algorithm
        this.head = this.head.next;

        // Recurse on the right hand side and form BST out of them
        node.right = this.convertListToBST(mid + 1, r);
        return node;
    }

    //利用了中序遍历的性质
    public TreeNode sortedListToBST1(ListNode head) {
        // Get the size of the linked list first
        int size = this.findSize(head);

        this.head = head;

        // Form the BST now that we know the size
        return convertListToBST(0, size - 1);
    }
}



