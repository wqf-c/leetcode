package Hot100;

/**
 * @author wqf
 * @date 2021/4/7 0:05
 * @Email:284660487@qq.com
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow && fast != null && slow != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                fast = null;
            }
        }
        if(fast == null || slow == null){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        Solution141 solution141 = new Solution141();
        solution141.hasCycle(node);
    }

}
