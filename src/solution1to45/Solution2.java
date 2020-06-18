package solution1to45;

/**
 * Author: wqf
 * Date: 2020/1/29
 * Time: 22:54
 */





public class Solution2 {

  public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int addNext = 0;
    ListNode newList = new ListNode((l1.val + l2.val)%10);
    addNext = (l1.val + l2.val) / 10;
    ListNode node = newList;
    int l1val = 0;
    int l2val = 0;
    l1 = l1.next;
    l2 = l2.next;
    for(;l1 != null || l2 != null;){

      if(l1 == null){
        l1val = 0;
      }else{
        l1val = l1.val;
        l1 = l1.next;
      }
      if(l2 == null){
        l2val = 0;
      }else{
        l2val = l2.val;
        l2 = l2.next;
      }
      ListNode newNode = new ListNode((l1val + l2val + addNext)%10);
      addNext = (l1val + l2val + addNext)/10;
      node.next = newNode;
      node = node.next;
    }
    if(addNext != 0){
      ListNode newNode = new ListNode(addNext);
      node.next = newNode;
    }
    return newList;
  }
}
