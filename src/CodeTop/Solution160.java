package CodeTop;

import Hot100.ListNode;

/**
 * @author wqf
 * @date 2021/5/4 23:50
 * @Email:284660487@qq.com
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB){
            if(nodeA == null) nodeA = headB;
            else nodeA = nodeA.next;
            if(nodeB == null) nodeB = headA;
            else nodeB = nodeB.next;
        }
        return nodeA;
    }

}
