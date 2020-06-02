package solution46to90;


/**
 * Author: wqf
 * Date: 2020/4/19
 * Time: 14:31
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class Solution82 {

  public static ListNode deleteDuplicates(ListNode head) {
    while (head != null && head.next != null && head.val == head.next.val){
      while (head != null && head.next != null && head.val == head.next.val){
        head = head.next;
      }
      head = head.next;
    }
    if(head == null || head.next == null || head.next.next == null) return head;
    ListNode prev = head;
    ListNode cur = head.next;
    ListNode next = cur.next;
    while (next != null){
      while (next != null && next.val == cur.val) {
        next = next.next;
      }
      if(next == cur.next){
        prev.next = cur;
        prev = cur;
        cur = next;
        next = next.next;
        continue;
      }
      if(next != null){
        if(next.next != null){
          if(next.val != next.next.val){
            prev.next = next;
            prev = next;
            cur = next.next;
            next = cur.next;
          }else{
            cur = next;
            next = cur.next;
          }
        }else{
          prev.next = next;
          next = null;
        }
      }else{
        prev.next = null;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(3);
    ListNode n5 = new ListNode(4);
    ListNode n6 = new ListNode(4);
    ListNode n7 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    ListNode n8 = deleteDuplicates(n1);
    System.out.println("=====");
  }
}
