package LinkList;

import java.util.Stack;

/**
 * @author wqf
 * @date 2020/12/15 17:42
 * @Email:284660487@qq.com
 */
public class Solution430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (node != null || !stack.empty()){
            if(node == null){
                Node next = stack.pop();
                node = next;
            }else{
                if(node.child == null){
                    if(node.next == null){
                        if(!stack.empty()){
                            Node peek = stack.peek();
                            peek.prev = node;
                            node.next = peek;
                        }
                        node = null;
                    }else node = node.next;

                }else{
                    node.child.prev = node;
                    if(node.next != null) stack.push(node.next);
                    node.next = node.child;
                    node.child = null;
                    node = node.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args){
        Node node1 = new Node();
        node1.val = 1;

        Node node2 = new Node();
        node2.val = 2;

        Node node3 = new Node();
        node3.val = 3;

        node1.next = node2;
        node1.child = node3;

        node2.prev = node1;
        Solution430 solution430 = new Solution430();
        solution430.flatten(node1);
    }

}
