package Hot100;

/**
 * @author wqf
 * @date 2021/3/5 16:28
 * @Email:284660487@qq.com
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        ListNode head = null, body = null;
        if(head1.val <= head2.val){
            head = head1;
            head1 = head1.next;
        }else{
            head = head2;
            head2 = head2.next;
        }
        body = head;
        while (head1 != null && head2 != null){
            if(head1.val < head2.val){
                body.next = head1;
                head1 = head1.next;
                body = body.next;
            }else{
                body.next = head2;
                head2 = head2.next;
                body = body.next;
            }
        }
        body.next = head1 == null ? head2 : head1;
        return head;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        Solution21 solution21 = new Solution21();
        solution21.mergeTwoLists(l1, l4);
    }

}
