package LinkList;

/**
 * @author wqf
 * @date 2020/12/27 18:21
 * @Email:284660487@qq.com
 */
public class Solution02_08 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //快慢指针  https://zhuanlan.zhihu.com/p/38521018
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;
        fast = head;
        while (true){
            if(fast == slow) break;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
