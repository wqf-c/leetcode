package solution46to90;



/**
 * Author: wqf
 * Date: 2020/3/7
 * Time: 1:16
 */
public class Solution61 {

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public ListNode rotateRight(ListNode head, int k) {
    if(head == null || head.next == null) return head;
    int count = 0;
    ListNode tempNode = head;
    while (tempNode != null){
      count++;
      tempNode = tempNode.next;
    }
    k = k % count;
    if(k == 0) return head;
    ListNode cur = head;
    count = 0;
    int[] save = new int[k];
    while (count != k){
      save[count] = cur.val;
      cur = cur.next;
      count ++;
    }
    int savePosition = 0;
    while (cur != null){
      int tempVal = cur.val;
      if (savePosition == k) savePosition = 0;
      cur.val = save[savePosition];
      save[savePosition] = tempVal;
      savePosition++;
      cur = cur.next;
    }
    cur = head;
    int s1 = savePosition;
    for(; savePosition < k; ++savePosition){
      cur.val = save[savePosition];
      cur = cur.next;
    }
    for(int i = 0; i < s1; ++i){
      cur.val = save[i];
      cur = cur.next;
    }
    return head;
  }

  //666
  public ListNode rotateRight1(ListNode head, int k) {
    if(head==null||k==0){
      return head;
    }
    ListNode cursor=head;
    ListNode tail=null;//尾指针
    int length=1;
    while(cursor.next!=null)//循环 得到总长度
    {
      cursor=cursor.next;
      length++;
    }
    int loop=length-(k%length);//得到循环的次数
    tail=cursor;//指向尾结点
    cursor.next=head;//改成循环链表
    cursor=head;//指向头结点
    for(int i=0;i<loop;i++){//开始循环
      cursor=cursor.next;
      tail=tail.next;
    }
    tail.next=null;//改成单链表
    return cursor;//返回当前头
  }
}
