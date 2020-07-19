package Solution91to135;

import org.omg.CORBA.NO_IMPLEMENT;

public class Solution117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null) return null;
        pre(root);
        return root;
    }

    void pre(Node node){
        if(node == null || (node.left == null && node.right == null)) return;
        if(node.left != null){
            if(node.right != null) node.left.next = node.right;
            else{
                Node next = node.next;
                while (next != null){
                    if(next.left != null || next.right != null){
                        node.left.next = next.left == null ? next.right : next.left;
                        break;
                    }
                    next = next.next;
                }

            }
        }
        if(node.right != null){
            Node next = node.next;
            while (next != null){
                if(next.left != null || next.right != null){
                    node.right.next = next.left == null ? next.right : next.left;
                    break;
                }
                next = next.next;
            }
        }
        pre(node.right);
        pre(node.left);
    }
}
