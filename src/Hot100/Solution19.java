package Hot100;

/**
 * @author wqf
 * @date 2021/3/2 0:09
 * @Email:284660487@qq.com
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode pre = head, next = head;
        for(int i = 0; i < n; ++i){
            next = next.next;
        }
        if(next == null) return head.next;
        while (next.next != null){
            next = next.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
