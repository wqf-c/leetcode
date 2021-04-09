package Hot100;

/**
 * @author wqf
 * @date 2021/4/7 21:23
 * @Email:284660487@qq.com
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null){
            slow = slow.next;
            if(fast.next == null){
                fast = null;
            }else{
                fast = fast.next.next;
            }
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
