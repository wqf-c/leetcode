package Hot100;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wqf
 * @date 2021/4/10 13:56
 * @Email:284660487@qq.com
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int aSize = 0, bSize = 0;
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != null){
            aSize++;
            nodeA = nodeA.next;
        }
        while (nodeB != null){
            bSize++;
            nodeB = nodeB.next;
        }
        int sizeDiff = Math.abs(bSize - aSize);
        if(bSize > aSize){
            for(int i = 0; i < sizeDiff; ++i){
                headB = headB.next;
            }
        }else{
            for(int i = 0; i < sizeDiff; ++i){
                headA = headA.next;
            }
        }
       while (headA != null && headB != null){
           if(headA == headB) return headA;
           else{
               headA = headA.next;
               headB = headB.next;
           }
       }
        return null;
    }

}
