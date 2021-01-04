package LinkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wqf
 * @date 2020/12/24 23:12
 * @Email:284660487@qq.com
 */
public class offer35 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        int nodeCount = 0;
        Map<Node, Integer> position = new HashMap<>();
        Node node = head;
        while (node != null){
            nodeCount++;
            position.put(node, nodeCount - 1);
            node = node.next;
        }
        Node[] nodes = new Node[nodeCount];
        node = head;
        int count = 0;
        while (node != null){
            if(nodes[count] == null){
                nodes[count] = new Node(node.val);
            }
            if(count >= 1) nodes[count - 1].next = nodes[count];
            if(node.random == null) nodes[count].random = null;
            else {
                int randomPosition = position.get(node.random);
                if (nodes[randomPosition] == null) {
                    nodes[randomPosition] = new Node(node.random.val);
                }
                nodes[count].random = nodes[randomPosition];
            }
            node = node.next;
            count++;
        }
        return nodes[0];
    }

    public static void main(String[] args){
        offer35 offer35 = new offer35();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;
        offer35.copyRandomList(node1);
    }
}
