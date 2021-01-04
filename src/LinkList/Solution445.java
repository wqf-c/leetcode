package LinkList;

import java.util.Stack;

/**
 * @author wqf
 * @date 2020/12/26 0:27
 * @Email:284660487@qq.com
 */
public class Solution445 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode liNode = l1;
        ListNode l2Node = l2;
        if(liNode != null && liNode.val == 0 && l2Node != null && l2Node.val == 0) return new ListNode(0);
        if(liNode == null && l2Node == null) return null;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (liNode != null){
            stack1.push(liNode.val);
            liNode = liNode.next;
        }
        while (l2Node != null){
            stack2.push(l2Node.val);
            l2Node = l2Node.next;
        }
        ListNode rst = null;
        ListNode last = null;
        int cache = 0;
        while (!stack1.empty() && !stack2.empty()){
            int num1 = stack1.pop();
            int num2 = stack2.pop();
            int cur = (num1 + num2 + cache) % 10;
            cache = (num1 + num2 + cache) / 10;
            rst = new ListNode(cur);
            rst.next = last;
            last = rst;
        }
        Stack<Integer> stack = stack1.empty() ? stack2 : stack1;
        while (!stack.empty()){
            int num = stack.pop();
            int cur = (num + cache) % 10;
            cache = (num + cache) / 10;
            rst = new ListNode(cur);
            rst.next = last;
            last = rst;
        }
        if(cache != 0){
            rst = new ListNode(cache);
            rst.next = last;
        }
        return rst;
    }

}
