package LinkList;

/**
 * @author wqf
 * @date 2020/12/23 17:35
 * @Email:284660487@qq.com
 */
public class M02_02 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        ListNode pre = head;
        ListNode next = head;
        for(int i = 1; i < k; ++i){
            next = next.next;
        }
        while (true){
            next = next.next;
            if(next == null) break;
            pre = pre.next;

        }
        return pre.val;
    }

}
