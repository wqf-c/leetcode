package Hot100;

/**
 * @author wqf
 * @date 2021/4/12 21:02
 * @Email:284660487@qq.com
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode pre = head;
        ListNode next = pre.next;
        while (next != null){
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        head.next = null;
        return pre;
    }

    //递归做法
    public ListNode reverseList1(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode newHead = reverseList1(head);
        head.next.next = head;
        head.next = null;
        return head;
    }

}
