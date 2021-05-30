package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/5/30 13:50
 * @Email:284660487@qq.com
 */
public class Solution23 {

    //分治
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode rst = null;
        for(int i = 0; i < lists.length; ++i){
            rst = merge2Lists(rst, lists[i]);
        }
        return rst;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null;
        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        ListNode body = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                body.next = l1;
                l1 = l1.next;
            }else{
                body.next = l2;
                l2 = l2.next;
            }
            body = body.next;
        }
        if(l1 == null){
            body.next = l2;
        }
        if(l2 == null){
            body.next = l1;
        }
        return head;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right){
        if(left >= lists.length) return null;
        if(left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode leftNode = merge(lists, left, mid);
        ListNode rightNode = merge(lists, mid + 1, right);
        return merge2Lists(leftNode, rightNode);
    }

}
