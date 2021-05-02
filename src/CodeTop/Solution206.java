package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/5/2 20:09
 * @Email:284660487@qq.com
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = head;
        while (next != null){
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        return pre;
    }

}
