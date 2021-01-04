package LinkList;

/**
 * @author wqf
 * @date 2020/12/23 17:40
 * @Email:284660487@qq.com
 */
public class Solution61 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode pre = head;
        ListNode last = head;
        int nodeCount = 0;
        while (true){
            nodeCount++;
            if(last.next == null) break;
            last = last.next;
        }
        last.next = pre;
        int step = k % nodeCount;
        int move = nodeCount - step - 1;
        for (int i = 0; i < move; ++i){
            pre = pre.next;
        }
        ListNode temp = pre.next;
        pre.next = null;
        return temp;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution61 solution61 = new Solution61();
        solution61.rotateRight(node1, 2);
    }

}
