package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2021/3/7 16:58
 * @Email:284660487@qq.com
 */
public class Solution23 {

    //187ms
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode head = null;
        int index = 0;
        for(int i = 0; i < lists.length; ++i){
            ListNode node = lists[i];
            if(node != null && (head == null || head.val > node.val)){
                head = node;
                index = i;
            }
        }
        if(head == null) return null;
        lists[index] = lists[index].next;
        ListNode[] nodes = new ListNode[lists.length];
        int nodesIndex = 0;
        for(int i = 0; i < lists.length; ++i){
            if(lists[i] != null){
                nodes[nodesIndex] = lists[i];
                nodesIndex++;
            }
        }
        dfs(nodes, head, nodesIndex);
        return head;
    }

    public void dfs(ListNode[] nodes, ListNode body, int nodesSize){
        if(nodesSize == 0) return;
        if(nodesSize == 1) body.next = nodes[0];
        ListNode minNode = nodes[0];
        int index = 0;
        for(int i = 1; i < nodesSize; ++i){
            if(minNode.val > nodes[i].val){
                minNode = nodes[i];
                index = i;
            }
        }
        body.next = minNode;
        body = body.next;
        nodes[index] = nodes[index].next;
        if(nodes[index] == null){
            for(int i = index; i < nodes.length - 1; ++i){
                nodes[i] = nodes[i + 1];
            }
            dfs(nodes, body, nodesSize - 1);
        }else{
            dfs(nodes, body, nodesSize);
        }
    }

    //1ms
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length == 0) return null;

        return merge(lists, 0, lists.length);
    }

    public ListNode merge(ListNode[] listNodes, int left, int right){
        if(left >= listNodes.length) return null;
        if(left == right) return listNodes[left];
        int mid = (left + right) / 2;
        ListNode leftNode = merge(listNodes, left, mid);
        ListNode rightNode = merge(listNodes, mid + 1, right);
        if(leftNode == null) return rightNode;
        if(rightNode == null) return leftNode;
        ListNode head = null;
        if(leftNode.val <= rightNode.val){
            head = leftNode;
            leftNode = leftNode.next;
        }else{
            head = rightNode;
            rightNode = rightNode.next;
        }
        ListNode body = head;
        while (leftNode != null && rightNode != null){
            if(leftNode.val <= rightNode.val){
                body.next = leftNode;
                leftNode = leftNode.next;
            }else {
                body.next = rightNode;
                rightNode = rightNode.next;
            }
            body = body.next;
        }
        body.next = leftNode == null ? rightNode : leftNode;
        return head;

    }
}
