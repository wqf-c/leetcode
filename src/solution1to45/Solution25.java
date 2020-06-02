package solution1to45;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/2/16
 * Time: 23:33
 */
public class Solution25 {

  public ListNode reverseKGroup(ListNode head, int k) {
    if(head == null || head.next == null) return head;
    if(k == 1) return head;
    int num = 0;
    ListNode save = head;
    while (save != null){
      save = save.next;
      num ++;
    }
    ListNode headSave = head;
    ListNode lastTail = head;
    save = head;
    for(int i = 0; i < num / k; ++i){
      List<ListNode> nodes = reverse(headSave, k);
      if(i == 0) save = nodes.get(0);
      if(i != 0) lastTail.next = nodes.get(0);
      lastTail = headSave;
      headSave = nodes.get(1);
      if(i == num / k - 1){
        lastTail.next = nodes.get(1);
        break;
      }
    }
    return save;
  }

  public static List<ListNode> reverse(ListNode head, int step){
    ListNode cur = head;
    ListNode pre = null;
    ListNode next = null;
    while (step != 0 && cur != null){
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
      step --;
    }
    List<ListNode> nodes = new ArrayList<>();
    Collections.addAll(nodes, pre, cur);
    return nodes;
  }

}
