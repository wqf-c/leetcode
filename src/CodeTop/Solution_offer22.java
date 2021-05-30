package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/5/22 1:13
 * @Email:284660487@qq.com
 */
public class Solution_offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode next = head, pre = head;
        for(int i = 1; i < k && next != null; ++i){
            next = next.next;
        }
        if(next == null) return null;
        while (next.next != null){
            next = next.next;
            pre = pre.next;
        }
        return pre;
    }

}
