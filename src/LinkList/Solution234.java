package LinkList;

/**
 * @author wqf
 * @date 2020/12/29 2:13
 * @Email:284660487@qq.com
 */
public class Solution234 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        ListNode cur = head, pre = null;
        while (fast != null && fast.next != null){
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
            pre = cur;
        }
        if(fast != null){
            slow = slow.next;
        }
        while (cur != null && slow != null){
            if(cur.val != slow.val) return false;
            cur = cur.next;
            slow = slow.next;
        }
        return true;
    }

}
