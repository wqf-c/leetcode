package solution1to45;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wqf
 * Date: 2020/2/14
 * Time: 19:47
 */

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class Solution19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    List<ListNode> saveNode = new ArrayList<>();
    ListNode curNode = head;
    while (curNode != null){
      saveNode.add(curNode);
      curNode = curNode.next;
    }
    if(n == saveNode.size()){
      return saveNode.get(0).next;
    }else{
      saveNode.get(saveNode.size() - n - 1).next = saveNode.get(saveNode.size() - n).next;
      return head;
    }
  }

  //执行用时 :
  //0 ms
  //, 在所有 Java 提交中击败了
  //100.00%
  //的用户...
  public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode preNode = null;
    ListNode nextNode = head;
    while (n > 0){
      nextNode = nextNode.next;
      n --;
    }

    while (nextNode != null){
      if(preNode == null){
        preNode = head;
      }else{
        preNode = preNode.next;
      }
      nextNode = nextNode.next;
    }
    if(preNode == null){
      return head.next;
    }else{
      preNode.next = preNode.next.next;
      return head;
    }
  }
}
