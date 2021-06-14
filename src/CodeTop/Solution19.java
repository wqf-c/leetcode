package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/6/4 23:40
 * @Email:284660487@qq.com
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode after = head;
        ListNode pre = head;
        for(int i = 0; i < n; ++i){
            after = after.next;
        }
        if(after == null) return head.next;
        while (after.next != null){
            after = after.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

}
