package Graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wqf
 * @date 2020/9/11 14:35
 * @Email:284660487@qq.com
 */

class Node {
    public int val;
    public List<Node> neighbors;
}

public class Solution133 {

    public static Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Integer, Node> nodes = new HashMap<>();
        Node head = new Node();
        head.val = node.val;
        head.neighbors = new ArrayList<>();
        nodes.put(head.val, head);
        List<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).addLast(node);
        while (!queue.isEmpty()){
            Node cur = ((LinkedList<Node>) queue).getFirst();
            ((LinkedList<Node>) queue).removeFirst();
            Node parent = nodes.get(cur.val);
            for(int i = 0; i < cur.neighbors.size(); ++i){
                Node nei = cur.neighbors.get(i);
                Node neighbor = null;
                if(nodes.containsKey(nei.val)){
                    neighbor = nodes.get(nei.val);
                }else{
                    neighbor = new Node();
                    neighbor.val = nei.val;
                    neighbor.neighbors = new ArrayList<>();
                    nodes.put(neighbor.val, neighbor);
                    ((LinkedList<Node>) queue).addLast(nei);
                }
                parent.neighbors.add(neighbor);
            }
        }
        return head;
    }

    public static void main(String[] args){
        Node node1 = new Node();
        node1.val = 1;
        node1.neighbors = new ArrayList<>();
        Node node2 = new Node();
        node2.val = 2;
        node2.neighbors = new ArrayList<>();
        Node node3 = new Node();
        node3.val = 3;
        node3.neighbors = new ArrayList<>();
        Node node4 = new Node();
        node4.val = 4;
        node4.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        cloneGraph(node1);
    }

}
