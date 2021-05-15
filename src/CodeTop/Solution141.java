package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/5/6 23:43
 * @Email:284660487@qq.com
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast != null && fast.next != null && fast == slow) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution141 solution141 = new Solution141();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(solution141.hasCycle(node1));
    }
}
