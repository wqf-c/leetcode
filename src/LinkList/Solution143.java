package LinkList;

/**
 * @author wqf
 * @date 2020/12/26 12:27
 * @Email:284660487@qq.com
 */
public class Solution143 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //先找到链表的中点，在逆序后帮段链表，最后插入
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode mid = head;
        ListNode last = head;
        while (last.next != null && last.next.next != null){
            mid = mid.next;
            last = last.next.next;
        }
        ListNode l1 = mid.next;
        l1 = reverseList(l1);
        mid.next = null;
        while (head != null && l1 != null){
            ListNode temp1 = head.next;
            ListNode temp2 = l1.next;
            head.next = l1;
            l1.next = temp1;
            l1 = temp2;
            head = temp1;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
