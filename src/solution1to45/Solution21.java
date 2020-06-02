package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/14
 * Time: 23:43
 */
public class Solution21 {

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

  //递归解法
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    else if (l2 == null) {
      return l1;
    }
    else if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    }
    else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }

  }



}



