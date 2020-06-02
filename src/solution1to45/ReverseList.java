package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/16
 * Time: 22:59
 */
public class ReverseList {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    ListNode n = reverseLise(node1);
    while (n != null){
      System.out.println(n.val);
      n = n.next;
    }
  }

  public static ListNode reverseLise(ListNode head){
    if(null == head || null == head.next){
      return head;
    }
    ListNode newHead = reverseLise(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
