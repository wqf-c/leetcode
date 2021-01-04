package LinkList;

/**
 * @author wqf
 * @date 2020/12/29 21:43
 * @Email:284660487@qq.com
 */
public class Solution237 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        ListNode node1 = node;
        ListNode pre = node1;
        while (node1 != null && node1.next != null){
            node1.val = node1.next.val;
            pre = node1;
            node1 = node1.next;
        }
        pre.next = null;
    }

}
