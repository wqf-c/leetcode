package CodeTop;

import Hot100.ListNode;

import java.util.Stack;

/**
 * @author wqf
 * @date 2021/6/13 18:04
 * @Email:284660487@qq.com
 */
public class Solution143 {

    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode pre = head, next = head;
        while (pre.next != null && next.next != null && next.next.next != null){
            pre = pre.next;
            next = next.next.next;
        }
        ListNode temp = pre.next;
        pre.next = null;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        pre = head;
        while (!stack.empty()){
            temp = pre.next;
            ListNode node = stack.pop();
            pre.next = node;
            node.next = temp;
            pre = temp;
        }
    }

    public void reorderList1(ListNode head) {
        if(head == null){
            return;
        }
        ListNode pre = head, next = head;
        while (next.next != null && next.next.next != null){
            pre = pre.next;
            next = next.next.next;
        }
        ListNode temp = pre.next;
        pre.next = null;
        ListNode node2 = reverseList(temp), node1 = head;
        while (node2 != null){
            ListNode temp1 = node1.next;
            ListNode temp2 = node2.next;
            node1.next = node2;
            node2.next = temp1;
            node2 = temp2;
            node1 = temp1;
        }
    }

    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode pre = head, next = head.next;
        pre.next = null;
        while (next != null){
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
       // node4.next = node5;
        solution143.reorderList1(node1);

    }

}
