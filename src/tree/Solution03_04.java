package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2020/11/6 21:14
 * @Email:284660487@qq.com
 */
public class Solution03_04 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    ListNode[] tempNode;
    int size = 0;
    ListNode[] lastNode;
    ListNode[] rst;

    public ListNode[] listOfDepth(TreeNode tree) {
        tempNode = new ListNode[1000];
        lastNode = new ListNode[1000];

        preOrder(tree, 1);
        rst = new ListNode[size];
        for(int i = 0; i < size; ++i){
            rst[i] = tempNode[i];
        }
        return rst;
    }

    public void preOrder(TreeNode node, int depth){
        if(node == null) return;
        ListNode node1 = new ListNode(node.val);
        if(size < depth){
            tempNode[size] = node1;
            lastNode[size] = node1;
            size = depth;
        }else{
            lastNode[depth - 1].next = node1;
            lastNode[depth - 1] = node1;
        }
        preOrder(node.left, depth + 1);
        preOrder(node.right, depth + 1);
    }
}
