package Hot100;

/**
 * @author wqf
 * @date 2021/2/9 11:35
 * @Email:284660487@qq.com
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = new ListNode();
        int jin = 0;
        ListNode node = head;
        while (node1 != null && node2 != null){
            int val = jin + node1.val + node2.val;
            node.val = val % 10;
            jin = val / 10;
            node1 = node1.next;
            node2 = node2.next;
            if(node1 == null && node2 == null) break;
            ListNode temp = new ListNode();
            node.next = temp;
            node = temp;
        }
        ListNode rest = (node1 == null && node2 == null) ? null : node1 == null ? node2 : node1;
        while (rest != null){
            int val = jin + rest.val;
            node.val = val % 10;
            jin = val / 10;
            rest = rest.next;
            if(rest == null) break;
            ListNode temp = new ListNode();
            node.next = temp;
            node = temp;
        }
        if(jin != 0){
            ListNode temp = new ListNode(jin);
            node.next = temp;
        }

        return head;
    }
}
