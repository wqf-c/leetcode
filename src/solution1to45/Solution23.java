package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/15
 * Time: 12:26
 */
public class Solution23 {

  public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length == 0) return null;
    if(lists.length == 1) return lists[0];
    int interval = 1;
    int amount = lists.length;
    while (interval < amount){
      for(int i = 0; i < amount - interval; i += interval * 2){
        lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
      }
      interval = interval * 2;
    }
    return lists[0];
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    ListNode head = null;
    ListNode curNode = null;
    if(l1.val > l2.val){
      head = l2;
      curNode = l2;
      l2 = l2.next;
    }else{
      head = l1;
      curNode = l1;
      l1 = l1.next;
    }
    while (l1 != null && l2 != null){
      if(l1.val > l2.val){
        curNode.next = l2;
        l2 = l2.next;
      }else{
        curNode.next = l1;
        l1 = l1.next;
      }
      curNode = curNode.next;
    }
    if(l1 != null) curNode.next = l1;
    if(l2 != null) curNode.next = l2;
    return head;
  }
}
