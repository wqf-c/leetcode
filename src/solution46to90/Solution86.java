package solution46to90;

public class Solution86 {

    //1ms
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode next = head;
        while (pre != null && pre.val < x){
            pre = pre.next;
        }
        next = pre;
        while (next != null){
            while (next != null && next.val >= x){
                next = next.next;
            }
            while (next != null && next.val < x){
                int temp = pre.val;
                ListNode n = pre.next;
                pre.val = next.val;
                while (n != next.next){
                    int temp2 = n.val;
                    n.val = temp;
                    temp = temp2;
                    n = n.next;
                }
                pre = pre.next;
            }
        }

        return head;
    }

    //0 ms
    public ListNode partition1(ListNode head, int x) {
        if(head==null){
            return null;
        }

        ListNode bigNum = new ListNode(-1);
        ListNode smallNum = new ListNode(-1);
        ListNode start = smallNum;
        ListNode bigHead = bigNum;
        ListNode smallHead = smallNum;
        while(head!=null){
            if(head.val<x){
                smallHead.next = head;
                smallHead = smallHead.next;
            }else{
                bigHead.next = head;
                bigHead = bigHead.next;
            }
            head =head.next;
        }

        smallHead.next = bigNum.next;
        bigHead.next = null;
        return smallNum.next;




    }
}
