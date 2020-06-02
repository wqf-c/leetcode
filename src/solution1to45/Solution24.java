package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/16
 * Time: 21:23
 */
public class Solution24 {

  public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    ListNode save = head.next;
    ListNode pre = head;
    ListNode next = head.next;
    ListNode lastNext = null;
    while (next != null){
      if(lastNext != null) lastNext.next = next;
      pre.next = next.next;
      next.next = pre;
      lastNext = pre;
      pre = pre.next;
      if(pre == null) break;
      next = pre.next;

    }
    return save;
  }
  //递归，对递归掌握不够熟练
  public ListNode swapPairs1(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    ListNode next = head.next;
    head.next = swapPairs1(next.next);
    next.next = head;
    return next;
  }
}
