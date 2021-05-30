package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/5/19 23:05
 * @Email:284660487@qq.com
 */
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode leftNode = head;
        ListNode leftPre = null;
        for(int i = 1; i < left; ++i){
            leftPre = leftNode;
            leftNode = leftNode.next;
        }
        ListNode pre = leftNode;
        ListNode next = pre.next;
        ListNode temp = null;
        for(int i = left; i < right; ++i){
            temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }

        if(leftPre != null){
            leftPre.next = pre;
        }
        leftNode.next = next;
        if(left == 1) return pre;
        else return head;


    }

}
