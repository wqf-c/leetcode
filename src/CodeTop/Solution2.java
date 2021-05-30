package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/5/30 12:07
 * @Email:284660487@qq.com
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l2 == null) return l1;
        if(l1 == null) return l2;
        int firstNum = l1.val + l2.val;
        ListNode head = null;
        int add = firstNum / 10;
        head = new ListNode(firstNum - add * 10);
        ListNode body = head;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null){
            int num = l1.val + l2.val + add;
            add = num / 10;
            int cur = num - add * 10;
            ListNode node = new ListNode(cur);
            body.next = node;
            body = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode rest = l1 != null ? l1 : l2;
        while (rest != null){
            int num = add + rest.val;
            add = num / 10;
            int cur = num - add * 10;
            ListNode node = new ListNode(cur);
            body.next = node;
            body = node;
            rest = rest.next;
        }
        if(add != 0){
            ListNode last = new ListNode(add);
            body.next = last;
        }
        return head;
    }

}
