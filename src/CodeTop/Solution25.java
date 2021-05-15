package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/5/3 20:27
 * @Email:284660487@qq.com
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        ListNode kHead = head, kTail = head;
        for(int i = 1; i < k; ++i){
            if(kTail == null) break;
            kTail = kTail.next;
        }
        if(kTail == null) return head;
        ListNode rst = kTail;
        while (kTail != null){
            ListNode prev = null;
            ListNode next = kHead, t = kHead;
            ListNode tailNext = kTail.next;
            while (next != tailNext){
                ListNode temp = next.next;
                next.next = prev;
                prev = next;
                next = temp;
            }
            kHead = tailNext;
            kTail = tailNext;
            for(int i = 1; i < k; ++i){
                if(kTail != null){
                    kTail = kTail.next;
                }
            }
            if(kTail != null){
                t.next = kTail;
            }else{
                t.next = kHead;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Solution25 solution25 = new Solution25();
        ListNode node = solution25.reverseKGroup(listNode1, 2);
        System.out.println(node);
    }

}
