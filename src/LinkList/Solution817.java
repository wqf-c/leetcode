package LinkList;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wqf
 * @date 2020/12/29 23:47
 * @Email:284660487@qq.com
 */
public class Solution817 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for(int g : G){
            set.add(g);
        }
        int max = 0;
        ListNode node = head;
        boolean flag = false;
        while (node != null){
            int val = node.val;
            if(set.contains(val)) {
                if (!flag) {
                    flag = true;
                    max++;
                }
            }else{
                flag = false;
            }
            node = node.next;
        }
        return max;
    }

    public boolean binarySearch(int[] G, int target){
        int left = 0, right = G.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(G[mid] == target) return true;
            if(G[mid] < target) left = mid + 1;
            if(G[mid] > target) right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args){
        Solution817 solution817 = new Solution817();
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        solution817.numComponents(node1, new int[]{0, 1, 3});
    }

}
