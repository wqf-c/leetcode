package Solution91to135;

public class Solution116 {

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
        pre(root);
        return root;
    }

    void pre(Node node){
        if(node.left == null) return;
        node.left.next = node.right;
        if(node.next != null){
            node.right.next = node.next.left;
        }
        pre(node.left);
        pre(node.right);
    }



}
