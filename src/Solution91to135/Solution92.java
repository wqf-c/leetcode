package Solution91to135;

import solution1to45.Solution2;

//´ýÐø


public class Solution92 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        ListNode startPre = null;
        ListNode start = head;
        ListNode endNext = null;
        ListNode end = head;
        ListNode pre = null;
        ListNode next = null;
        for(int i = 1; i <= n; ++i){
            if(i == m - 1){
                startPre = start;
            }
            if(i < m){
                start = start.next;
                end = end.next;
            }
            if(i == m){
                pre = start;
                next = pre.next;
            }
            if(i >= m && i < n){
                ListNode temp = next.next;
                next.next = pre;
                pre = next;
                next = temp;
                if(i == n - 1){
                    end = pre;
                    endNext = temp;
                }
            }
        }
        if(startPre != null) startPre.next = end;
        start.next = endNext;
        if(m == 1) return end;
        else return head;
    }

    public static void main(String[] args){
        Solution92 s = new Solution92();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        l3.next = l5;
        s.reverseBetween(l3, 1, 2);
    }
}
