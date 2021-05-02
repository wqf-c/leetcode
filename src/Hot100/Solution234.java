package Hot100;

/**
 * @author wqf
 * @date 2021/4/14 0:21
 * @Email:284660487@qq.com
 */
public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        //找到中点
        ListNode slow = head, fast = head;
        ListNode hou = null, qian = null;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null){
            //节点数为偶数
            hou = slow;
        }else{
            //节点数为奇数
            hou = slow.next;
        }
        ListNode pre = null, next = head;
        while (next.next != slow){
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        next.next = pre;
        qian = next;
        while (hou != null){
            if(hou.val != qian.val) return false;
            hou = hou.next;
            qian = qian.next;
        }
        return true;
    }

}
