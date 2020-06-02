package solution46to90;

/**
 * Author: wqf
 * Date: 2020/4/20
 * Time: 20:46
 */
public class Solution83 {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head;
    ListNode next = head.next;
    while (next != null){
      while (next != null && next.val == cur.val){
        next = next.next;
      }
      cur.next = next;
      if(next != null){
        cur = next;
        next = cur.next;
      }

    }
    return head;
  }
}
