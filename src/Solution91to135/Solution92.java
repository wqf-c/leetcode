package Solution91to135;

import solution1to45.Solution2;

//´ýÐø
public class Solution92 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        ListNode startPre = null;
        ListNode start = head;
        ListNode endNext = head;
        ListNode end = null;
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
                    end = next;
                    endNext = temp;
                }
            }
        }
        startPre.next = end;
        start.next = endNext;
        return head;
    }
}
