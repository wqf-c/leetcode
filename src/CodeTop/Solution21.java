package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/5/4 23:41
 * @Email:284660487@qq.com
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode rst = null, node = null;
        if(l1.val < l2.val){
            rst = l1;
            node = l1;
            l1 = l1.next;
        }else{
            rst = l2;
            node = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return rst;
    }

}
