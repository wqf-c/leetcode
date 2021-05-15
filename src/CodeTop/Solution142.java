package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/5/12 21:39
 * @Email:284660487@qq.com
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        while (slow != null && fast != null){
            if(fast.next == null){
                fast = null;
            }else{
                fast = fast.next.next;
            }
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast == null || slow == null) return null;
        ListNode pre = head;
        while (pre != slow){
            pre = pre.next;
            slow = slow.next;
        }
        return pre;
    }

}
